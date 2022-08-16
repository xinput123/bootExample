package com.xinput.boot.controller;

import com.xinput.boot.config.JwtConfig;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
public class TokenController {
  @Resource
  private JwtConfig jwtConfig;

  // 拦截器直接放行，返回Token
  @PostMapping("/login")
  public Map<String, String> login(@RequestParam("userName") String userName,
                                   @RequestParam("passWord") String passWord) {
    Map<String, String> result = new HashMap<>();
    // 省略数据源校验
    String token = jwtConfig.getToken(userName + passWord);
    if (!StringUtils.isEmpty(token)) {
      result.put("token", token);
    }
    result.put("userName", userName);
    return result;
  }

  // 需要 Token 验证的接口
  @PostMapping("/info")
  public String info() {
    return "info";
  }
}