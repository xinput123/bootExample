package com.xinput.boot.config;

import com.xinput.boot.consts.ResultCode;
import com.xinput.boot.consts.ResultData;
import com.xinput.boot.exception.BootBusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局统一异常处理
 */
@RestControllerAdvice
public class ExceptionResponseAdvice {

  private static final Logger logger = LoggerFactory.getLogger(ExceptionResponseAdvice.class);

  @ResponseBody
  @ExceptionHandler(value = BootBusinessException.class)
  public ResultData bootUnexpectedExceptionHandler(BootBusinessException businessException) {
    ResultData resultData = new ResultData(businessException.getErrCode(), businessException.getErrMsg());
    return resultData;
  }

  /**
   * 所有Exception的异常
   */
  @ResponseBody
  @ExceptionHandler(value = Exception.class)
  public ResultData exceptionHandler(Exception e) {
    ResultData resultData = new ResultData(ResultCode.ERROR.getCode(), e.getMessage());
    return resultData;
  }

  /**
   * 所有Error的异常
   */
  @ResponseBody
  @ExceptionHandler(value = Error.class)
  public ResultData errorHandler(Error error) {
    ResultData resultData = new ResultData(ResultCode.ERROR.getCode(), error.getMessage());
    return resultData;
  }

  /**
   * 最高等级的Throwable异常
   */
  @ExceptionHandler(value = Throwable.class)
  public ResultData throwableHandler(Throwable throwable) {
    ResultData resultData = new ResultData(ResultCode.ERROR.getCode(), throwable.getMessage());
    return resultData;
  }
}
