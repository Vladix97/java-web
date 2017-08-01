package com.self_made_mvc.dispatchers;

import com.self_made_mvc.models.ControllerActionPair;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by vladix on 8/1/17.
 */
public interface Dispatcher {

    ControllerActionPair dispatchRequest(HttpServletRequest request);

    String dispatchAction(HttpServletRequest request, HttpServletResponse response, ControllerActionPair controllerActionPair);
}
