package com.self_made_mvc.handlers;

import com.self_made_mvc.annotations.controller.Controller;
import com.self_made_mvc.annotations.request.GetMapping;
import com.self_made_mvc.annotations.request.PostMapping;
import com.self_made_mvc.models.ControllerActionPair;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by vladix on 8/1/17.
 */
public class HandlerMappingImpl implements HandlerMapping {

    @Override
    public ControllerActionPair findController(HttpServletRequest request)
            throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String urlPath = request.getRequestURI();
        String projectPath = URLDecoder.decode(request.getServletContext().getResource("/WEB-INF/classes").getPath(), "UTF-8");
        String absolute = request.getServletContext().getRealPath("/WEB-INF/classes");
        List<Class> controllers = this.findAllControllers(absolute);

        for (Class controller : controllers) {
            Method[] methods = controller.getDeclaredMethods();
            for (Method method : methods) {
                String methodPath = this.findMethodPath(request, method);
                if (method == null) {
                    continue;
                }

                if (this.isPathMatching(urlPath, methodPath)) {
                    ControllerActionPair controllerActionPair = new ControllerActionPair(controller, method);
                    this.addPathVariables(controllerActionPair, urlPath, methodPath);

                    return controllerActionPair;
                }
            }
        }

        throw new IllegalArgumentException("Controller not found!");
    }

    private void addPathVariables(ControllerActionPair controllerActionPair, String urlPath, String methodPath) {
        String[] uriTokens = urlPath.split("/");
        String[] methodTokens = methodPath.split("/");

        for (int i = 0; i < uriTokens.length; i++) {
            if (methodTokens[i].startsWith("{") && methodTokens[i].endsWith("}")) {
                String key = methodTokens[i].replace("{", "").replace("}", "");
                String value = uriTokens[i];
                controllerActionPair.addPathVariable(key, value);
            }
        }
    }

    private boolean isPathMatching(String urlPath, String methodPath) {
        String[] uriTokens = urlPath.split("/");
        String[] methodTokens = methodPath.split("/");

        if (uriTokens.length != methodPath.length()) {
            return false;
        }

        for (int i = 0; i < uriTokens.length; i++) {
            if (methodTokens[i].startsWith("{") && methodTokens[i].endsWith("}")) {
                continue;
            }

            if (!uriTokens[i].equals(methodTokens[i])) {
                return false;
            }
        }

        return true;
    }

    private String findMethodPath(HttpServletRequest request, Method method) {
        String value = null;
        switch (request.getMethod()) {
            case "GET":
                GetMapping getMapping = method.getAnnotation(GetMapping.class);
                if (getMapping != null) {
                    value = getMapping.value();
                }
                break;
            case "POST":
                PostMapping postMapping = method.getAnnotation(PostMapping.class);
                if (postMapping != null) {
                    value = postMapping.value();
                }
                break;
        }

        return value;
    }

    private List<Class> findAllControllers(String projectDirectory) throws ClassNotFoundException {
        List<Class> controllerClasses = new ArrayList<>();
        File directory = new File(projectDirectory);
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                Class currentClass = this.getClass(file);
                if (currentClass == null) {
                    continue;
                }

                if (currentClass.isAnnotationPresent(Controller.class)) {
                    controllerClasses.add(currentClass);
                }
            } else if (file.isDirectory()) {
                String subDirectory = file.getAbsolutePath();
                List<Class> allControllers = findAllControllers(subDirectory);
                controllerClasses.addAll(allControllers);
            }
        }

        return controllerClasses;
    }

    private Class getClass(File file) throws ClassNotFoundException {
        String absolutePath = file.getAbsolutePath();
        String classPattern = "^(.+classes\\\\)(.+)(.class)$";
        Pattern pattern = Pattern.compile(classPattern);
        Matcher matcher = pattern.matcher(absolutePath);
        Class currentClass = null;
        if (matcher.find()) {
            String className = matcher.group(2).replace("\\", ".");
            if (!className.endsWith("DispatcherServlet")) {
                currentClass = Class.forName(className);
            }
        }

        return currentClass;
    }
}
