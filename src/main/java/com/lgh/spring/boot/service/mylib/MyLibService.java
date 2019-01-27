package com.lgh.spring.boot.service.mylib;

import com.lgh.spring.boot.mongo.model.mylib.MDoc;
import com.lgh.spring.boot.pojo.common.PageKeywordQuery;
import com.lgh.spring.boot.pojo.common.Response;
import com.lgh.spring.boot.pojo.library.CreateDocRequest;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MyLibService {
    /**
     * create Doc
      * @param request request
     * @return result
     */
    Response createDoc(CreateDocRequest request);

    /**
     * findAll
     * @return docs
     */
    List<MDoc> findAll();

    /**
     * find
     * @param query query
     * @return List<MDoc>
     */
    Page<MDoc> find(PageKeywordQuery query);
}
