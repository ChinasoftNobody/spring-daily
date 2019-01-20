package com.lgh.spring.boot.service.library;


import com.lgh.spring.boot.mongo.model.library.MBook;

import java.util.List;

public interface BookService {
    /**
     * 查询图书馆同意检索平台相关书籍信息
     * @param keyword keyword
     * @return result
     */
    List<MBook> remoteSearch(String keyword);
}
