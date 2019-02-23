package com.lgh.spring.boot.service.library.impl;

import com.lgh.spring.boot.mongo.model.MBase;
import com.lgh.spring.boot.mongo.model.library.MBook;
import com.lgh.spring.boot.mongo.repo.BookRepo;
import com.lgh.spring.boot.pojo.library.QueryBookRequest;
import com.lgh.spring.boot.service.library.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Resource
    private BookRepo bookRepo;

    @Override
    public Page<MBook> queryBooks(QueryBookRequest request) {
        if (StringUtils.isEmpty(request.getKeyword())) {
            return bookRepo.findAll(PageRequest.of(request.getPage(), request.getSize()));
        }
        return bookRepo.findAllByNameContaining(request.getKeyword(), PageRequest.of(request.getPage(), request.getSize()));
    }

    @Override
    public List<MBook> addBatch(List<MBook> books) {
        books.forEach(MBase::generateBaseInfo);
        return bookRepo.saveAll(books);
    }

}
