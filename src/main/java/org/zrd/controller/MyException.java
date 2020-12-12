package org.zrd.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author zrd
 * @Date 2020/12/12
 */
@ControllerAdvice
public class MyException {

    @ExceptionHandler(Exception.class)
    public ModelAndView fileUploadException(Exception e) {
        ModelAndView error = new ModelAndView("error");
        error.addObject("error", e.getMessage());
        return error;
    }

}
