package com.xinput.boot.gof.chain.handler;

import com.xinput.boot.gof.chain.dto.Request;
import com.xinput.boot.gof.chain.dto.Response;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 安全校验对象
 */
@Order(2)
@Component
public class CheckSecurityFilterObject extends AbstractHandler {
  @Override
  void doFilter(Request filterRequest, Response response) {
    System.out.println("安全调用校验");
  }
}
