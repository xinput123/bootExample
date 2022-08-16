package com.xinput.boot.consts;

import lombok.Getter;

/**
 * TODO
 *
 * @author xinput
 * @since
 */
@Getter
public enum ResultCode {
  SUCCESS(2000, "请求成功"),
  FAILED(1001, "请求失败"),
  VALIDATE_ERROR(1002, "参数校验失败"),
  RESPONSE_PACK_ERROR(1003, "response返回包装失败"),
  PARAM_ERROR(1004, "参数格式错误"),
  AUTH_ERROR(1201, "身份验证失败"),
  AUTH_EXPIRED(1202, "身份令牌过期"),
  ERROR(5000, "系统内部错误");

  private int code;
  private String msg;

  public int getCode() {
    return code;
  }

  public String getMsg() {
    return msg;
  }

  ResultCode(int code, String msg) {
    this.code = code;
    this.msg = msg;
  }
}
