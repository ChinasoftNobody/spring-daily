package com.lgh.spring.boot.service.library;


import com.lgh.spring.boot.mongo.model.library.MBook;
import com.lgh.spring.boot.pojo.library.QueryBookRequest;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BookService {

    /**
     * 查询书籍信息
     * @param request request
     * @return result
     */
    Page<MBook> queryBooks(QueryBookRequest request);

    /**
     * 批量添加书籍
     * @param books books
     * @return result
     */
    List<MBook> addBatch(List<MBook> books);
}
