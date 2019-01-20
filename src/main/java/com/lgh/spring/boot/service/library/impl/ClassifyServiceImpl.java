package com.lgh.spring.boot.service.library.impl;


import com.lgh.spring.boot.mongo.model.library.MClassify;
import com.lgh.spring.boot.mongo.repo.ClassifyRepo;
import com.lgh.spring.boot.service.library.ClassifyService;
import com.lgh.spring.boot.util.RestTemplateUtil;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.annotation.Resource;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClassifyServiceImpl implements ClassifyService {
    @Resource
    private ClassifyRepo classifyRepo;

    @Override
    public boolean resetClassifyInfo() {
        classifyRepo.deleteAll();
        List<MClassify> classifies = new ArrayList<>();
        String url = "http://opac.cdclib.org/opac/browse/query?category=cls&id=0";
        getClassifiesFromUrl(classifies, url);
        classifyRepo.saveAll(classifies);
        return true;
    }

    /**
     * 从图书馆网站抓取最新的分类信息
     *
     * @param classifies classifies
     * @param url        url
     */
    private void getClassifiesFromUrl(List<MClassify> classifies, String url) {
        String xmlStr = RestTemplateUtil.get(url);
        List<MClassify> classifyList = parseClassify(xmlStr);
        if (classifyList != null && !classifyList.isEmpty()) {
            for (MClassify classify : classifyList) {
                classifies.add(classify);
                if (classify.isHasChildren()) {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    getClassifiesFromUrl(classifies, "http://opac.cdclib.org/opac/browse/query?category=cls&id=" + classify.getNumber());
                }
            }
        }
    }

    /**
     * 解析xml信息
     *
     * @param xmlStr xmlStr
     * @return 返回解析后的分类信息
     */
    private List<MClassify> parseClassify(String xmlStr) {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(new ByteArrayInputStream(xmlStr.getBytes(StandardCharsets.UTF_8)));
            NodeList record = document.getElementsByTagName("record");
            List<MClassify> classifies = new ArrayList<>();
            if (record.getLength() > 0) {
                for (int i = 0; i < record.getLength(); i++) {
                    Node node = record.item(i);
                    NodeList childNodes = node.getChildNodes();
                    if (childNodes.getLength() > 0) {
                        MClassify classify = new MClassify();
                        classify.setSource("中图法");
                        for (int j = 0; j < childNodes.getLength(); j++) {
                            Node subNode = childNodes.item(j);
                            switch (subNode.getNodeName()) {
                                case "id":
                                    classify.setNumber(Integer.valueOf(subNode.getFirstChild().getTextContent()));
                                    break;
                                case "parentId":
                                    classify.setParentNumber(Integer.valueOf(subNode.getFirstChild().getTextContent()));
                                    break;
                                case "name":
                                    classify.setName(subNode.getFirstChild().getTextContent());
                                    break;
                                case "categoryDesc":
                                    classify.setDescription(subNode.getFirstChild().getTextContent());
                                    break;
                                case "childrenCount":
                                    if (Integer.valueOf(subNode.getFirstChild().getTextContent()) > 0) {
                                        classify.setHasChildren(true);
                                    }
                                    break;
                            }
                        }
                        classifies.add(classify);
                    }
                }
            }
            return classifies;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
