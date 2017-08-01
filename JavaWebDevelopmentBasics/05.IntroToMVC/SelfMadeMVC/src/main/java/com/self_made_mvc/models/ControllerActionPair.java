package com.self_made_mvc.models;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * Created by vladix on 8/1/17.
 */
public class ControllerActionPair {

    private Class controllerClass;

    private Method method;

    private Map<String, String> pathVariables;

    public ControllerActionPair(Class controllerClass, Method method) {
        this.controllerClass = controllerClass;
        this.method = method;
    }

    public Class getControllerClass() {
        return this.controllerClass;
    }

    public Method getMethod() {
        return this.method;
    }

    public void addPathVariable(String key, String value) {
        this.pathVariables.put(key, value);
    }

    public String getPathVariable(String key) {
        return this.pathVariables.get(key);
    }
}
