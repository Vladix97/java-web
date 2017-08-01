package com.self_made_mvc.handlers;

import com.self_made_mvc.models.ControllerActionPair;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by vladix on 8/1/17.
 */
public interface HandlerMapping {

    ControllerActionPair findController(HttpServletRequest request)
            throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException;
}
