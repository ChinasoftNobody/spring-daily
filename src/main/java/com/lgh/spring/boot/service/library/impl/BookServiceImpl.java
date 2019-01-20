package com.lgh.spring.boot.service.library.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lgh.spring.boot.mongo.model.library.MBook;
import com.lgh.spring.boot.mongo.model.library.MResource;
import com.lgh.spring.boot.service.library.BookService;
import com.lgh.spring.boot.service.library.ResourceService;
import com.lgh.spring.boot.util.RestTemplateUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private static final Log LOG = LogFactory.getLog(BookServiceImpl.class);
    @Value("${url.combinedParsedResult}")
    private String remoteUrl;
    @Resource
    private ResourceService resourceService;

    @Override
    public List<MBook> remoteSearch(String keyword) {
        if (StringUtils.isEmpty(keyword)) {
            return Collections.emptyList();
        }
        try {
            String jsonStr = searchBooks(keyword);
            if (StringUtils.isEmpty(jsonStr)) {
                return Collections.emptyList();
            }
            JSONArray array = JSONArray.parseArray(jsonStr);
            List<MBook> books = new ArrayList<>(array.size());
            if (!array.isEmpty()) {
                for (Object o : array) {
                    JSONObject object = (JSONObject) o;
                    MBook book = packUpBookFromJson(object);
                    books.add(book);
                }
            }
            return books;
        } catch (Exception e) {
            LOG.error(e);
            return Collections.emptyList();
        }
    }

    /**
     * 查询书籍接口
     * 先由各资源查询各资源结果后，将结果放入历史中，
     * 最后调用组合接口获取书籍信息 此过程应用统一的session
     *
     * @param keyword keyword
     * @return 书籍信息（json）
     */
    private String searchBooks(String keyword) {
        HashMap<String, Object> params = pickUpParamsMap();
        List<MResource> resources = resourceService.queryExternalResource();
        if (resources == null || resources.isEmpty()) {
            return null;
        }
        for (MResource resource : resources) {
            HashMap<String, Object> param = new HashMap<>();
            param.put("searchField", null);
            param.put("searchValue", keyword);
            param.put("page", 1);
            param.put("pageSize", 10);
            param.put("resourceId", resource.getResourceId());
            param.put("noCacheId", System.currentTimeMillis());
            //TODO 获取书籍信息
        }
        return RestTemplateUtil.get(remoteUrl, params);
    }

    /**
     * 构造调用统一检索书籍接口参数
     *
     * @return result
     */
    private HashMap<String, Object> pickUpParamsMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("noCacheId", String.valueOf(System.currentTimeMillis()));
        map.put("page", String.valueOf(System.currentTimeMillis()));
        map.put("resourceId", resourceService.queryExternalResource());
        map.put("orderField", null);
        map.put("isDescOrder", false);
        return map;
    }

    /**
     * 通过检索外部接口得到的json信息封装book信息
     *
     * @param object object
     * @return book
     */
    private MBook packUpBookFromJson(JSONObject object) {
        MBook book = new MBook();
        book.setNumber(object.getInteger("id"));
        book.setAddedAuthorOrEditor(object.getString("addedAuthorOrEditor"));
        book.setAddedCorpAuthor(object.getString("addedCorpAuthor"));
        book.setAuthorList(object.getJSONArray("authorList"));
        book.setBookRecNo(object.getString("bookRecNo"));
        book.setCitation(object.getString("citation"));
        book.setClassnoList(object.getJSONArray("classnoList"));
        book.setCombinedTime(object.getLong("combinedTime"));
        book.setCreateTime(object.getLong("createTime"));
        book.setDescription(object.getString("description"));
        book.setDownloadLink(object.getString("downloadLink"));
        book.setFromSource(object.getString("fromSource"));
        book.setGcxx(object.getString("gcxx"));
        book.setInternetAccess(object.getString("internetAccess"));
        book.setDetailPageParsed(object.getBoolean("isDetailPageParsed"));
        book.setIsbnList(object.getJSONArray("isbnList"));
        book.setIssn(object.getString("issn"));
        book.setJournalVolInfo(object.getString("journalVolInfo"));
        book.setKeywordList(object.getJSONArray("keywordList"));
        book.setLanguage(object.getString("language"));
        book.setLastAccessTime(object.getLong("lastAccessTime"));
        book.setMetaInfo(object.getJSONObject("metaInfo"));
        book.setOnlineLink(object.getString("onlineLink"));
        book.setPage(object.getInteger("page"));
        book.setPublicationDate(object.getString("publicationDate"));
        book.setPublicationYear(object.getString("publicationYear"));
        book.setPublisher(object.getString("publisher"));
        book.setRepeatParsedResultList(object.getJSONArray("repeatParsedResultList"));
        book.setRepeatSize(object.getInteger("repeatSize"));
        book.setRequestKey(object.getString("requestKey"));
        book.setResourceId(object.getString("resourceId"));
        book.setResourceName(object.getString("resourceName"));
        book.setSeries(object.getString("series"));
        book.setSessionId(object.getString("sessionId"));
        book.setSetNumber(object.getInteger("setNumber"));
        book.setSubjectList(object.getJSONArray("subjectList"));
        book.setSummary(object.getString("summary"));
        book.setTitle(object.getString("title"));
        book.setTitleHref(object.getString("titleHref"));
        book.setTypeList(object.getJSONArray("typeList"));
        return book;
    }
}
