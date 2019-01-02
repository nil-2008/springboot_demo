package com.nil.freemarker.controller;

import com.nil.freemarker.pojo.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lianyou
 * @version 1.0
 * @date 2019/1/2 13:49
 */
@Controller
@RequestMapping("ftl")
public class FreemarkerController {
  @Autowired
  private Resource resource;

  @RequestMapping(value = "/index")
  public String index(ModelMap map) {
   map.addAttribute("resource",resource);
    return "freemarker/index";
  }

  @RequestMapping(value = "center")
  public String center() {
    return "freemarker/center/center";
  }
}
