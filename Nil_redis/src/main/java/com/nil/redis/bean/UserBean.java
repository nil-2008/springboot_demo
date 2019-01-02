package com.nil.redis.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author lianyou
 * @version 1.0
 * @date 2018/12/29 22:18
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserBean {
  private Integer id;
  private String name;
  private int age;
}
