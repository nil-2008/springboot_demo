package com.nil.controller;

import com.nil.bean.UserBean;
import com.nil.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author lianyou
 * @version 1.0
 * @date 2018/12/30 14:24
 */
@RestController
@RequestMapping("/user")
public class UserController {
  @Autowired private UserService userService;

  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public List<UserBean> getUserList() {
    return userService.findUserList();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public UserBean findUser(@PathVariable("id") int id) {
    return userService.findUser(id);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public String updateUser(
      @PathVariable("id") int id,
      @RequestParam(value = "name", required = true) String name,
      @RequestParam(value = "age", required = true) int age) {
    int num = userService.update(name, age, id);
    return (num == 1) ? "success" : "fail";
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public String delete(@PathVariable(value = "id") int id) {
    int num = userService.delete(id);
    return (num == 1) ? "success" : "fail";
  }

  @RequestMapping(value = "", method = RequestMethod.POST)
  public String addUser(
      @RequestParam(value = "name", required = true) String name,
      @RequestParam(value = "age", required = true) int age) {
    int num = userService.add(name, age);
    return (num == 1) ? "success" : "fail";
  }
}
