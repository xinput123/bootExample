package com.xinput.boot.gof.chain.handler;

import com.xinput.boot.gof.chain.dto.Request;
import com.xinput.boot.gof.chain.dto.Response;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 黑名单校验对象
 */
@Order(3)
@Component
public class CheckBlackFilterObject extends AbstractHandler {
  @Override
  void doFilter(Request filterRequest, Response response) {
    System.out.println("校验黑名单");
  }
}
