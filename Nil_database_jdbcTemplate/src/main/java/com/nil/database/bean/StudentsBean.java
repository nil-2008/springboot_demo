package com.nil.database.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 学生实体类
 *
 * @author lianyou
 * @version 1.0
 * @date 2018/12/29 19:05
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class StudentsBean {
  private int id;
  private String name;
  private int age;
}
