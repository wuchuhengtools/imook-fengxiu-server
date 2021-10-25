package com.zhuche.server.core;

public class UnifyResponse {
    private final int code;

    private final String message;

    private final String request;

    public String getRequest() {
        return request;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public UnifyResponse(int code, String message, String url) {
        this.code = code;
        this.message = message;
        this.request = url;
    }
}
