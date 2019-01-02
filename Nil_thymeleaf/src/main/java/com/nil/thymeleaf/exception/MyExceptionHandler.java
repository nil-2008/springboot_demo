package com.nil.thymeleaf.exception;

import com.nil.thymeleaf.pojo.JSONResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 助手类
 *
 * @author lianyou
 * @version 1.0
 * @date 2019/1/2 16:38
 */
@ControllerAdvice
public class MyExceptionHandler {
  public static final String ERROR_VIEW = "error";

  @ExceptionHandler(value = Exception.class)
  public Object errorHandler(HttpServletRequest reqest, HttpServletResponse response, Exception e)
      throws Exception {

    e.printStackTrace();

    if (isAjax(reqest)) {
      return JSONResult.errorException(e.getMessage());
    } else {
      ModelAndView mav = new ModelAndView();
      mav.addObject("exception", e);
      mav.addObject("url", reqest.getRequestURL());
      mav.setViewName(ERROR_VIEW);
      return mav;
    }
  }

  /** @Title: IMoocExceptionHandler.java @Package com.imooc.exception @Description: 判断是否是ajax请求 */
  public static boolean isAjax(HttpServletRequest httpRequest) {
    return (httpRequest.getHeader("X-Requested-With") != null
        && "XMLHttpRequest".equals(httpRequest.getHeader("X-Requested-With").toString()));
  }
}
