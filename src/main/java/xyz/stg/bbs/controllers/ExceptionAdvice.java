package xyz.stg.bbs.controllers;

import xyz.stg.bbs.controllers.dto.Result;
import xyz.stg.bbs.exception.ForbiddenException;
import xyz.stg.bbs.exception.ResourceNotFoundException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by shitiangao on 16/7/22.
 */
@ControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseBody
    public Result resourceNotFoundException(ResourceNotFoundException e) {
        return Result.failed(e.getMessage(), e.getCause());
    }

    @ExceptionHandler(ForbiddenException.class)
    @ResponseBody
    public Result forbiddenException(ForbiddenException e) {
        return Result.failed(e.getMessage(), e.getCause());
    }
}
