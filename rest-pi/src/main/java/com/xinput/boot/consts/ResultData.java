package com.xinput.boot.consts;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ResultData implements Serializable {
  private static final long serialVersionUID = -8430270886489542792L;

  // true表示结果正常
  private boolean success;

  private int code;

  private String em;

  private Object data;

  public ResultData(Object data) {
    this.success = true;
    this.code = ResultCode.SUCCESS.getCode();
    this.data = data;
  }

  public ResultData(ResultCode resultCode) {
    this.success = false;
    this.code = resultCode.getCode();
    this.em = resultCode.getMsg();
  }

  public ResultData(int code, String em) {
    this.success = false;
    this.code = code;
    this.em = em;
  }
}
