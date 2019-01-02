package com.nil.thymeleaf.exception;

import com.nil.thymeleaf.pojo.JSONResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lianyou
 * @version 1.0
 * @date 2019/1/2 16:50
 */
@RestControllerAdvice
public class MyAjaxExceptionHandler {

  @ExceptionHandler(value = Exception.class)
  public JSONResult defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {

    e.printStackTrace();
    return JSONResult.errorException(e.getMessage());
  }
}
