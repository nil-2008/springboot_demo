package com.nil.database.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

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
  @JsonIgnore
  private int id;
  private String name;
  /** 忽略 */
  @JsonIgnore
  private int age;
  /** 设置时间格式，或略空值 */
  @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss a", locale = "zh", timezone = "Asia/shanghai")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private Date birthday;
}
