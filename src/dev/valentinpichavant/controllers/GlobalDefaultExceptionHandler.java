package dev.valentinpichavant.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * Created by valentinpichavant on 1/9/17.
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {

    /*@ExceptionHandler(Throwable.class)
    public String handleAnyException(Throwable ex, HttpServletRequest request) {
        return "error404";
    }*/
}
