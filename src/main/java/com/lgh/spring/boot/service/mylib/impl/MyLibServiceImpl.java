package com.lgh.spring.boot.service.mylib.impl;

import com.lgh.spring.boot.hbase.helper.FileRowHelper;
import com.lgh.spring.boot.hbase.model.FileRow;
import com.lgh.spring.boot.mongo.model.mylib.MDoc;
import com.lgh.spring.boot.mongo.repo.mylib.MyLibRepo;
import com.lgh.spring.boot.pojo.common.PageKeywordQuery;
import com.lgh.spring.boot.pojo.common.Response;
import com.lgh.spring.boot.pojo.library.CreateDocRequest;
import com.lgh.spring.boot.service.mylib.MyLibService;
import com.lgh.spring.boot.util.ResponseUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.io.IOException;
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
        String fileId = UUID.randomUUID().toString();
        doc.setFileId(fileId);
        doc.setFileName(request.getFile().getOriginalFilename());
        FileRow fileRow = new FileRow();
        fileRow.setFileId(fileId);
        fileRow.setMod("doc");
        try {
            fileRow.setContent(request.getFile().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseUtil.error("file read error");
        }
        if (!fileRowHelper.insert(fileRow)) {
            return ResponseUtil.error("save file error");
        }
        myLibRepo.save(doc);
        return ResponseUtil.success(doc);
    }

    @Override
    public List<MDoc> findAll() {
        return myLibRepo.findAll();
    }

    @Override
    public Page<MDoc> find(PageKeywordQuery query) {
        if (query == null){
            return findAll(PageRequest.of(0, 10));
        }
        if (query.getPage() < 0) {
            query.setPage(0);
        }
        if (query.getSize() < 0) {
            query.setSize(10);
        }
        if (StringUtils.isEmpty(query.getKeyword())) {
            return findAll(PageRequest.of(query.getPage(), query.getSize()));
        }
        return myLibRepo.findBySubjectContains(query.getKeyword(), PageRequest.of(query.getPage(), query.getSize()));
    }

    private Page<MDoc> findAll(Pageable pageable) {
        return myLibRepo.findAll(pageable);
    }
}
