package com.lgh.spring.boot.service.library;

import com.lgh.spring.boot.mongo.model.library.MBook;
import org.springframework.data.domain.Page;

/**
 * 图书馆服务
 * 用于处理与图书馆相关交互
 */
public interface LibraryService {
    /**
     * 查询四川省图书馆的书籍
     * 全文关键字搜索
     * @param keyword keyword
     * @return result
     */
    Page<MBook> queryFromScLib(String keyword);
}
