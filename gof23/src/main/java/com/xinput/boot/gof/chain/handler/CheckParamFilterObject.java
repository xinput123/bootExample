package com.xinput.boot.gof.chain.handler;

import com.xinput.boot.gof.chain.dto.Request;
import com.xinput.boot.gof.chain.dto.Response;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 参数校验对象
 */
@Order(1)
@Component
public class CheckParamFilterObject extends AbstractHandler {
  @Override
  void doFilter(Request filterRequest, Response response) {
    System.out.println("非空参数检查");
  }
}
