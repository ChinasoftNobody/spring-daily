package com.lgh.spring.boot.service.mylib.impl;

import com.lgh.spring.boot.hbase.helper.FileRowHelper;
import com.lgh.spring.boot.hbase.model.FileRow;
import com.lgh.spring.boot.mongo.model.mylib.MDoc;
import com.lgh.spring.boot.mongo.repo.mylib.MyLibRepo;
import com.lgh.spring.boot.pojo.common.Response;
import com.lgh.spring.boot.pojo.library.CreateDocRequest;
import com.lgh.spring.boot.service.mylib.MyLibService;
import com.lgh.spring.boot.util.ResponseUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class MyLibServiceImpl implements MyLibService {
    @Resource
    private MyLibRepo myLibRepo;
    @Resource
    private FileRowHelper fileRowHelper;

    @Override
    public Response createDoc(CreateDocRequest request) {
        if (request == null || StringUtils.isEmpty(request.getSubject()) || StringUtils.isEmpty(request.getType())) {
            return ResponseUtil.error("invalid param");
        }
        if (myLibRepo.findFirstBySubject(request.getSubject()) != null) {
            return ResponseUtil.error("subject exist");
        }
        MDoc doc = new MDoc(true);
        doc.setSubject(request.getSubject());
        doc.setType(request.getType());
        ArrayList<String> files = new ArrayList<>();
        String fileId = UUID.randomUUID().toString();
        files.add(fileId);
        doc.setFiles(files);
        FileRow fileRow = new FileRow();
        fileRow.setFileId(fileId);
        fileRow.setMod("doc");
        try {
            fileRow.setContent(request.getFile().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseUtil.error("file read error");
        }
        if (!fileRowHelper.insert(fileRow)){
            return ResponseUtil.error("save file error");
        }
        myLibRepo.save(doc);
        return ResponseUtil.success(doc);
    }

    @Override
    public List<MDoc> findAll() {
        return myLibRepo.findAll();
    }
}
