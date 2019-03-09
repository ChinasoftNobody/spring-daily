package com.lgh.spring.boot.util;

import com.lgh.spring.boot.pojo.common.Response;

public class ResponseUtil {

    /**
     * success
     * @param result result
     * @return response
     */
    public static <T> Response<T> success(T result){
        return new Response(true, null, result);
    }


    /**
     * error
     * @param error reason
     * @return response
     */
    public static <T> Response<T> error(String error) {
        return new Response(false, error, null);
    }
}
