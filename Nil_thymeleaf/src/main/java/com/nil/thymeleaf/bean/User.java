package com.nil.thymeleaf.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author lianyou
 * @version 1.0
 * @date 2019/1/2 14:49
 */
@Setter
@Getter
public class User {
  private int id;
  @JsonIgnore private String name;
  private int age;

  @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss a", locale = "zh", timezone = "Asia/shanghai")
  private Date birthday;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String desc;
}
