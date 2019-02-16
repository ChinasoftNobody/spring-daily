package com.lgh.spring.boot.service.mylib;

import com.lgh.spring.boot.pojo.common.Response;
import com.lgh.spring.boot.pojo.library.CreateDocRequest;

public interface MyLibService {
    /**
     * create Doc
      * @param request request
     * @return result
     */
    Response createDoc(CreateDocRequest request);

}
