package com.nil.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 来标注一个主程序类，说明这是一个Spring Boot应用
 *
 * <p>@SpringBootApplication：标注在某个类上就说明这个类是SpringBoot的主配置类
 *
 * <p>SpringBoot就应该运行这个类的main方法,来启动SpringBoot应用
 *
 * @author lianyou
 */
@SpringBootApplication
public class DemoApplication {

  public static void main(String[] args) {
    // Spring应用启动
    SpringApplication.run(DemoApplication.class, args);
  }
}
