package com.lgh.spring.boot.controller.library;

import com.lgh.spring.boot.service.library.BookService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * library management
 */
@RestController
@RequestMapping("/library")
public class LibraryController {

    @Resource
    private BookService bookService;



}
