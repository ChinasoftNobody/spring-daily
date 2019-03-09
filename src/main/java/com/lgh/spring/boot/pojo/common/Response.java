package com.lgh.spring.boot.pojo.common;

/**
 * 公共对象，用于统一后端接口返回格式
 */
public class Response<T> {
    private boolean success;
    private String error;
    private T result;

    public Response(boolean success, String error, T result) {
        this.success = success;
        this.error = error;
        this.result = result;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }


}
