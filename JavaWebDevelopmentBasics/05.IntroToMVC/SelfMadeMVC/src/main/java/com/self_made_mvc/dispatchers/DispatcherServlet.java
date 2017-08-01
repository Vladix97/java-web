package com.self_made_mvc.dispatchers;

import com.self_made_mvc.handlers.HandlerAction;
import com.self_made_mvc.handlers.HandlerActionImpl;
import com.self_made_mvc.handlers.HandlerMapping;
import com.self_made_mvc.handlers.HandlerMappingImpl;
import com.self_made_mvc.models.ControllerActionPair;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URLDecoder;

/**
 * Created by vladix on 8/1/17.
 */
@WebServlet(name = "dispatcherServlet", value = "/")
public class DispatcherServlet extends HttpServlet implements Dispatcher {

    private HandlerMapping handlerMapping;

    private HandlerAction handlerAction;

    public DispatcherServlet() {
        this.handlerMapping = new HandlerMappingImpl();
        this.handlerAction = new HandlerActionImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (this.isResource(req)) {
            this.sendResourceRespond(req, resp);
        }

        this.handleRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.handleRequest(req, resp);
    }

    @Override
    public ControllerActionPair dispatchRequest(HttpServletRequest request) {
        ControllerActionPair controllerActionPair = null;
        try {
            controllerActionPair = this.handlerMapping.findController(request);
        } catch (IOException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return controllerActionPair;
    }

    @Override
    public String dispatchAction(HttpServletRequest request, HttpServletResponse response, ControllerActionPair controllerActionPair) {
        String view = null;

        try {
            view = this.handlerAction.executeControllerAction(request,response, controllerActionPair);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return view;
    }

    private void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ControllerActionPair controllerActionPair = this.dispatchRequest(request);
        if (controllerActionPair != null) {
            String view = this.dispatchAction(request, response, controllerActionPair);
            if (view.startsWith("redirect:")) {
                String redirectPath = view.replace("redirect:", "");
                response.sendRedirect(redirectPath);
            } else {
                request.getRequestDispatcher("/" + view + ".jsp").forward(request, response);
            }
        }
    }

    private boolean isResource(HttpServletRequest request) {
        boolean isResource = false;
        String url = request.getRequestURI();
        if (url.contains(".")) {
            isResource = true;
        }

        return isResource;
    }

    private void sendResourceRespond(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String url = request.getRequestURI();
        String directory = URLDecoder.decode(request.getServletContext().getResource("/").getPath(), "UTF-8");
        File file = new File(directory + url);
        try (
                BufferedReader bfr = new BufferedReader(new FileReader(file))
                ) {
            String line;
            while ((line = bfr.readLine()) != null) {
                response.getWriter().print(line);
            }
        }
    }
}
