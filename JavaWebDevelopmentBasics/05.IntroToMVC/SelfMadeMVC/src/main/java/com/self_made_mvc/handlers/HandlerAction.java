package com.self_made_mvc.handlers;

import com.self_made_mvc.models.ControllerActionPair;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by vladix on 8/1/17.
 */
public interface HandlerAction {

    String executeControllerAction(HttpServletRequest request, HttpServletResponse response, ControllerActionPair controllerActionPair)
            throws InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException, NamingException;
}
