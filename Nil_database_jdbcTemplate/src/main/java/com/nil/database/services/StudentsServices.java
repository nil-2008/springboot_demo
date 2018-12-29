package com.nil.database.services;

import com.nil.database.bean.StudentsBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author lianyou
 * @version 1.0
 * @date 2018/12/29 19:17
 */
@Service
public class StudentsServices {
  @Autowired private JdbcTemplate jdbcTemplate;

  public List<StudentsBean> getStudentsList() {
    return jdbcTemplate.query(
        "select * from students",
        new RowMapper<StudentsBean>() {
          @Override
          public StudentsBean mapRow(ResultSet resultSet, int i) throws SQLException {
            StudentsBean studentsBean = new StudentsBean();
            studentsBean.setId(resultSet.getInt("id"));
            studentsBean.setName(resultSet.getString("name"));
            studentsBean.setAge(resultSet.getInt("age"));

            return studentsBean;
          }
        });
  }
}
