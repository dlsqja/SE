package com.se.demo.global.response;

import java.util.HashMap;
import java.util.Map;

public class CustomResponse {
    private Map<Object,Object> response = new HashMap<>();

    public CustomResponse(Object object) {
        response.put("body",object);
        response.put("message","success");
    }
    public Map<Object, Object> getResponse() {
        return response;
    }
}
