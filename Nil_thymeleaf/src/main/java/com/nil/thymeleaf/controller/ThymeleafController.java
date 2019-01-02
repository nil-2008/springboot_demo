package com.nil.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lianyou
 * @version 1.0
 * @date 2019/1/2 14:34
 */
@Controller
@RequestMapping(value = "th")
public class ThymeleafController {
  @RequestMapping(value = "/index")
  public String index(ModelMap map) {
    map.addAttribute("name", "thymeleaf-nil");
    return "thymeleaf/index";
  }

  @RequestMapping(value = "center")
  public String center() {
    return "thymeleaf/center/center";
  }
}
