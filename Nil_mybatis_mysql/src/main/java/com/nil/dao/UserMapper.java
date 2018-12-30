package com.nil.dao;

import com.nil.bean.UserBean;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @Mapper将UserMapper声明为一个Mapper接口
 *
 * @author lianyou
 * @version 1.0
 * @date 2018/12/30 14:00
 */
@Mapper
public interface UserMapper {
  /**
   * 新增记录
   *
   * @param name
   * @param age
   * @return
   */
  @Insert("Insert INTO user(name,age) values(#{name},#{age})")
  int add(@Param("name") String name, @Param("age") int age);

  /**
   * 更新记录
   *
   * @param name
   * @param age
   * @param id
   * @return
   */
  @Update("UPDATE user set name=#{name},age=#{age} where id=#{id}")
  int update(@Param("name") String name, @Param("age") int age, @Param("id") int id);

  /**
   * 删除记录
   *
   * @param id
   * @return
   */
  @Delete("DELETE FROM user where id=#{id}")
  int delete(int id);

  /**
   * 查询一条记录
   *
   * @param id
   * @return
   */
  @Select("SELECT id,name,age from user where id =#{id}")
  UserBean findUser(@Param("id") int id);

  /**
   * 返回所有记录
   *
   * @return
   */
  @Select("SELECT id,name,age from user")
  List<UserBean> findUserList();
}
