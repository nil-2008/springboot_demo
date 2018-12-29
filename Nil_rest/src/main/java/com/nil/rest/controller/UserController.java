package com.nil.rest.controller;

import com.nil.rest.bean.UserBean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lianyou
 * @version 1.0
 * @date 2018/12/29 17:07
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
  @RequestMapping
  public String index() {
    return "hello index";
  }

  @RequestMapping(value = "/getMap")
  public Map<String, Object> getMap(String msg) {
    HashMap<String, Object> map = new HashMap<>();

    map.put("name", "lianyou");
    map.put("gender", "大老爷们");
    map.put("message", msg);

    return map;
  }

  @RequestMapping(value = "/getUser/{name}/{gender}")
  public UserBean getUser(@PathVariable String name, @PathVariable char gender) {
    UserBean userBean = new UserBean();

    userBean.setId(1);
    userBean.setName(name);
    userBean.setGender(gender);
    userBean.setDate(new Date());

    return userBean;
  }
}
