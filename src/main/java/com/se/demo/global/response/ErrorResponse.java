package com.se.demo.global.response;

import java.util.HashMap;
import java.util.Map;

public class ErrorResponse {
    private Map<Object,Object> response = new HashMap<>();

    public ErrorResponse(String message) {
        response.put("body",null);
        response.put("message",message);
    }
    public Map<Object, Object> getResponse() {
        return response;
    }
}
