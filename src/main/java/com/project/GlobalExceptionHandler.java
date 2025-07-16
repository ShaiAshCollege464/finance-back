package com.project;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler
    public void handleException (Exception ex, HttpServletRequest request, HttpServletResponse response) {
        try {
            System.out.println("handleException");
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.setStatus(HttpStatus.NOT_FOUND.value());
    }
}
