package com.fcgl.madrid.healthcheck;

/**
 * Health Object
 */
public class Health {

    private int statusCode;
    private String message;

    /**
     * @param statusCode Non-Http Code. Internal Status Code
     * @param message A message describing the Health of the system
     */
    Health(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
