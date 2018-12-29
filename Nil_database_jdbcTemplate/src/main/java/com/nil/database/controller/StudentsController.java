package com.nil.database.controller;

import com.nil.database.bean.StudentsBean;
import com.nil.database.services.StudentsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author lianyou
 * @version 1.0
 * @date 2018/12/29 19:23
 */
@RestController
@RequestMapping(value = "/user")
public class StudentsController {
  @Autowired private StudentsServices studentsServices;

  @RequestMapping(value = "/list")
  public List<StudentsBean> getStudentrList() {
    return studentsServices.getStudentsList();
  }
}
