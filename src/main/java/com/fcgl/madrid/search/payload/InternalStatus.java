package com.fcgl.madrid.search.payload;


import org.springframework.http.HttpStatus;
import java.util.List;
import java.util.ArrayList;

public class InternalStatus {
    public static final InternalStatus OK = new InternalStatus(StatusCode.OK, HttpStatus.OK, "ok");
    public static final InternalStatus MISSING_PARAM = new InternalStatus(StatusCode.PARAM, HttpStatus.BAD_REQUEST, "Missing Required Param");
    public static final InternalStatus NOT_FOUND = new InternalStatus(StatusCode.NOT_FOUND, HttpStatus.NOT_FOUND, "Data Not Found");

    private int code;
    private HttpStatus httpCode;
    private List<String> messages;

    public InternalStatus() {

    }

    public InternalStatus(StatusCode statusCode, HttpStatus httpCode, String message) {
        this.code = statusCode.getCode();
        this.httpCode = httpCode;
        this.messages = new ArrayList<String>();
        this.messages.add(message);
    }

    public InternalStatus(StatusCode statusCode, HttpStatus httpCode, List<String> messages) {
        this.code = statusCode.getCode();
        this.httpCode = httpCode;
        this.messages = messages;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public HttpStatus getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(HttpStatus httpCode) {
        this.httpCode = httpCode;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;

        InternalStatus that = (InternalStatus) object;

        if (code != that.code) return false;
        if (httpCode != that.httpCode) return false;
        return messages != null ? messages.equals(that.messages) : that.messages == null;
    }

    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + code;
        result = 31 * result + (httpCode != null ? httpCode.hashCode() : 0);
        result = 31 * result + (messages != null ? messages.hashCode() : 0);
        return result;
    }
}

