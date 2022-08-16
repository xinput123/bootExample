package com.xinput.boot.intercept;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 第二个拦截器
 */
public class SecondInterceptor implements HandlerInterceptor {

  private static final Logger LOGGER = LoggerFactory.getLogger(SecondInterceptor.class);

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    String url = String.valueOf(request.getRequestURL());
    LOGGER.info("2、url == " + url);

    // 放开拦截
    return true;
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    LOGGER.info("2、postHandler");
  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    LOGGER.info("2、afterCompletion");
  }
}
