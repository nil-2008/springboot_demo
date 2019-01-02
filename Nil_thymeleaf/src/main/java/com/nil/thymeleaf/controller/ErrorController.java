package com.nil.thymeleaf.controller;

import com.nil.thymeleaf.pojo.JSONResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 引入统一的异常捕获
 *
 * @author lianyou
 * @version 1.0
 * @date 2019/1/2 16:33
 */
@Controller
@RequestMapping(value = "err")
public class ErrorController {

  @RequestMapping("/error")
  public String error() {

    int a = 1 / 0;

    return "thymeleaf/error";
  }

  @RequestMapping("/ajaxerror")
  public String ajaxerror() {

    return "thymeleaf/ajaxerror";
  }

  @RequestMapping("/getAjaxerror")
  @ResponseBody
  public JSONResult getAjaxerror() {

    int a = 1 / 0;

    return JSONResult.ok();
  }
}
