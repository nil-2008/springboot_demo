package com.nil.redis.controller;

import com.nil.redis.bean.UserBean;
import com.nil.redis.utils.JsonUtils;
import com.nil.redis.utils.RedisOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lianyou
 * @version 1.0
 * @date 2019/1/2 19:25
 */
@RestController
@RequestMapping(value = "redis")
public class RedisController {
  @Autowired private StringRedisTemplate strRedis;
  @Autowired private RedisOperator redis;

  @RequestMapping(value = "/string")
  public String test() {
    String key = "test";
    strRedis.opsForValue().set(key, "hello springboot");
    return strRedis.opsForValue().get(key);
  }

  @RequestMapping(value = "/json")
  public String jsonUser() {
    String key = "json:info:user";

    UserBean userBean = new UserBean();
    userBean.setId(10000);
    userBean.setName("tom");
    userBean.setAge(15);

    redis.set(key, JsonUtils.objectToJson(userBean), 2000);

    String userJson = redis.get(key);

    return userJson;
  }
}
