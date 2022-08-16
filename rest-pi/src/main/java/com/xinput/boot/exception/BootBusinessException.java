package com.xinput.boot.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * 业务异常
 *
 * @author <a href="mailto:xinput.xx@gmail.com">xinput</a>
 * @Date: 2016-04-03 11:15
 */
@Getter
@Setter
public final class BootBusinessException extends RuntimeException {

  private int errCode;

  private String errMsg;

  public BootBusinessException(int errCode, String errMsg) {
    this.errCode = errCode;
    this.errMsg = errMsg;
  }

  public BootBusinessException(String message, int errCode, String errMsg) {
    super(message);
    this.errCode = errCode;
    this.errMsg = errMsg;
  }

  public BootBusinessException(String message, Throwable cause, int errCode, String errMsg) {
    super(message, cause);
    this.errCode = errCode;
    this.errMsg = errMsg;
  }

  public BootBusinessException(Throwable cause, int errCode, String errMsg) {
    super(cause);
    this.errCode = errCode;
    this.errMsg = errMsg;
  }

  public BootBusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, int errCode, String errMsg) {
    super(message, cause, enableSuppression, writableStackTrace);
    this.errCode = errCode;
    this.errMsg = errMsg;
  }
}
