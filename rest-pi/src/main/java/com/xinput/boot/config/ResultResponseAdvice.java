package com.xinput.boot.config;

import com.github.xinput.commons.JsonHelper;
import com.xinput.boot.consts.ResultData;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 对返回结果进行统一处理
 */
@RestControllerAdvice("com.xinput.boot.controller")
public class ResultResponseAdvice implements ResponseBodyAdvice<Object> {

  @Override
  public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
    return true;
  }

  @Override
  public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
    // 应对特殊case，返回类型是String不做处理会导致StringMessageConverter转换异常，将其封装并转换为json对象
    if (body instanceof String) {
      String stringBody = (String) body;
      ResultData result = new ResultData(stringBody);
      return JsonHelper.toJsonString(result);
    }

    // 返回本身就是 ResultData 类型，不需要进行任何处理
    if (body instanceof ResultData) {
      return body;
    }

    // 进行一层包装
    return new ResultData(body);
  }
}
