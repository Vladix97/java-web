package com.self_made_mvc.models;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by vladix on 8/1/17.
 */
public class Model {

    private HttpServletRequest request;

    private Map<String, Object> attributes;

    public Model(HttpServletRequest request) {
        this.attributes = new HashMap<>();
    }

    public void addAttribute(String key, Object value) {
        this.attributes.put(key, value);
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }
}
