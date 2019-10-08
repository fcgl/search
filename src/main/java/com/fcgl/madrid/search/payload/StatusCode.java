package com.fcgl.madrid.search.payload;

public class StatusCode {
    public static final StatusCode UNKNOWN = new StatusCode(-1);
    public static final StatusCode OK = new StatusCode(1);
    public static final StatusCode PARAM = new StatusCode(2);
    public static final StatusCode NOT_FOUND = new StatusCode(3);
    public static final StatusCode AUTH_ERROR = new StatusCode(4);

    private int code;

    StatusCode(int code) {
        this.code = code;
    }


    public int getCode() {
        return code;
    }

}
