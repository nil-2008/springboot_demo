package com.nil.thymeleaf.controller;

import com.nil.thymeleaf.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

  @RequestMapping(value = "test")
  public String test(ModelMap map) {
    User user = new User();
    user.setName("jerry");
    user.setAge(18);
    user.setBirthday(new Date());
    user.setDesc("<font color='red'><b>hello</b></font>");

    map.addAttribute("user", user);

    List<User> userList = new ArrayList<>();
    userList.add(user);
    userList.add(user);
    userList.add(user);

    map.addAttribute("userList",userList);
    return "thymeleaf/test";
  }

  @PostMapping(value = "postform")
  public String postform(User u) {
    System.out.println("name: " + u.getName() + ",age:" + u.getAge());
    return "redirect:/th/test";
  }

  //  @PostMapping(value = "showerror")
  //  public String showerror(User u) {
  //    int a = 1 / 0;
  //    return "redirect:/th/test";
  //  }
}
