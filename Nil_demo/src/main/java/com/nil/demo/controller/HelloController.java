package com.nil.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController == @Controller + @ResponseBody，需要注意的是使用这个注解代表着整个一类都是如此
 *
 * <p>当然 @Controller & @ResponseBody 还是可以使用的
 *
 * @author lianyou
 * @version 1.0
 * @date 2018/12/29 15:08
 */
@RestController
public class HelloController {
  /** 接口地址 */
  @RequestMapping(
      value = {"/index", "/"},
      method = RequestMethod.GET)
  public String index() {
    return "4444。";
  }
}
