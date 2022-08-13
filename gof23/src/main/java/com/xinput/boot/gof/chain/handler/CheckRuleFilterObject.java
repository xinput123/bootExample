package com.xinput.boot.gof.chain.handler;

import com.xinput.boot.gof.chain.dto.Request;
import com.xinput.boot.gof.chain.dto.Response;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 规则拦截对象
 */
@Order(4)
@Component
public class CheckRuleFilterObject extends AbstractHandler {
  @Override
  void doFilter(Request filterRequest, Response response) {
    System.out.println("check rule");
  }
}
