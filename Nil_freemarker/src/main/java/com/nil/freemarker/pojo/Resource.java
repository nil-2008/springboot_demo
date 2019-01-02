package com.nil.freemarker.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author lianyou
 * @version 1.0
 * @date 2019/1/2 14:01
 */
@Configuration
@ConfigurationProperties(prefix = "com.nil.open-source")
@PropertySource(value = "classpath:resource.properties")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Resource {
  private String name;
  private String website;
  private String language;
}
