package com.lgh.spring.boot.controller.library;

import com.lgh.spring.boot.pojo.common.Response;
import com.lgh.spring.boot.pojo.library.AddBookRequest;
import com.lgh.spring.boot.pojo.library.QueryBookRequest;
import com.lgh.spring.boot.service.library.BookService;
import com.lgh.spring.boot.util.ResponseUtil;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/book", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class BookController {
    @Resource
    private BookService bookService;

    @PostMapping("/query")
    public Response queryBooks(@RequestBody @Validated QueryBookRequest request) {
        return ResponseUtil.success(bookService.queryBooks(request));
    }

    @PostMapping("/add")
    public Response addBooks(@RequestBody @Validated AddBookRequest request){
        return ResponseUtil.success(bookService.addBatch(request.getBooks()));
    }
}
