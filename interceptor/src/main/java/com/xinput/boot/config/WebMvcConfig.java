package com.xinput.boot.config;

import com.xinput.boot.intercept.FirstInterceptor;
import com.xinput.boot.intercept.SecondInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Web配置文件中注入拦截器
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

  /**
   * 拦截所有路径
   * 注册自定义的两个拦截器
   */
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new FirstInterceptor()).addPathPatterns("/**");
    registry.addInterceptor(new SecondInterceptor()).addPathPatterns("/**");
  }
}
