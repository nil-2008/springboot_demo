package com.nil.service;

import com.nil.bean.UserBean;
import com.nil.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 这是一个服务Bean
 *
 * <p>@Service 声明成一个spring bean
 *
 * @author lianyou
 * @version 1.0
 * @date 2018/12/30 14:09
 */
@Service
public class UserService {
  /// ** 连接到 UserMapper UserBean */
  @Autowired private UserMapper userMapper;

  /**
   * 添加记录
   *
   * @param name
   * @param age
   * @return
   */
  public int add(String name, int age) {
    return userMapper.add(name, age);
  }

  /**
   * 更新记录
   *
   * @param name
   * @param age
   * @param id
   * @return
   */
  public int update(String name, int age, int id) {
    return userMapper.update(name, age, id);
  }

  /**
   * 删除记录
   *
   * @param id
   * @return
   */
  public int delete(int id) {
    return userMapper.delete(id);
  }

  /**
   * 根据主键查询用户
   *
   * @param id
   * @return
   */
  public UserBean findUser(int id) {
    return userMapper.findUser(id);
  }

  /**
   * 查询所有记录
   *
   * @return
   */
  public List<UserBean> findUserList() {
    return userMapper.findUserList();
  }
}
