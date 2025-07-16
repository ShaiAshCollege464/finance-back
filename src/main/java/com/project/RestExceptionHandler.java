package com.project;

import com.project.Utils.CustomLogger;
import com.project.Utils.LogType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class RestExceptionHandler extends DefaultHandlerExceptionResolver {

    private final static CustomLogger LOGGER = new CustomLogger(RestExceptionHandler.class);

    @ExceptionHandler(Throwable.class)
    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) {
        if (!(e instanceof IOException)) {
            LOGGER.log(e,String.format("Received exception in REST controller, in path=%s, params: %s",
                    request.getRequestURI(), request.getQueryString()), e);
        } else {
            LOGGER.log(LogType.warn,String.format("client aborted request before it was done, path: %s", request.getRequestURL()));
        }
        return super.doResolveException(request, response, handler, e);
    }
}