package com.nil.rest.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * 用户实体
 *
 * @author lianyou
 * @version 1.0
 * @date 2018/12/29 17:04
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserBean {
  private Integer id;
  private String name;
  private Date date;
  private char gender;
}
