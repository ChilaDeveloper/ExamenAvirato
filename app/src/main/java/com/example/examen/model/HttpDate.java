package com.example.examen.model;

public class HttpDate {
    private int statusCode;
    private String body;


    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Status Code = "+getStatusCode()+"\n"+"Body = "+getBody();
    }
}
