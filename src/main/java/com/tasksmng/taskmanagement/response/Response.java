package com.tasksmng.taskmanagement.response;

public class Response {
    private final int status;
    private final String message;
    private final Object result;

    public Response(int status, String message) {
        this.status = status;
        this.message = message;
        this.result = null;
    }

    public Response(int status, String message, Object result) {
        this.status = status;
        this.message = message;
        this.result = result;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Object getResult() {
        return result;
    }
}
