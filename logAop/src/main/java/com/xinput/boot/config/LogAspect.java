package com.xinput.boot.config;

import com.github.xinput.commons.JsonHelper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 编写日志记录的切面代码
 *
 * @Aspect: 作用是把当前类标识为一个切面供容器读取
 * @Pointcut： Pointcut是植入Advice的触发条件。每个Pointcut的定义包括2部分，一是表达式，二是方法签名。方法签名必须是 public及void型。可以将Pointcut中的方法看作是一个被Advice引用的助记符，因为表达式不直观，因此我们可以通过方法签名的方式为 此表达式命名。因此Pointcut中的方法只需要方法签名，而不需要在方法体内编写实际代码。
 * @Around： 环绕增强，相当于MethodInterceptor
 * @AfterReturning： 后置增强，相当于AfterReturningAdvice，方法正常退出时执行
 * @Before： 标识一个前置增强方法，相当于BeforeAdvice的功能，相似功能的还有
 * @AfterThrowing： 异常抛出增强，相当于ThrowsAdvice
 * @After: final增强，不管是抛出异常或者正常退出都会执行
 */

@Aspect
@Component
@EnableAspectJAutoProxy
public class LogAspect {

  private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

  @Pointcut("@annotation(com.xinput.boot.config.Log)")
  public void methodPointcut() {

  }

  @Pointcut("@within(com.xinput.boot.config.Log)")
  public void classPointcut() {
  }

  @Around("methodPointcut() || classPointcut()")
  public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
    long start = System.currentTimeMillis();
    Signature signature = joinPoint.getSignature();
    MethodSignature methodSignature = (MethodSignature) signature;
    Method method = methodSignature.getMethod();
    String methodName = method.getName();

    Object[] args = joinPoint.getArgs();

    logger.info("方法调用前:{}, 参数:{}", methodName, JsonHelper.toJsonString(args));
    try {
      Object res = joinPoint.proceed(args);
      logger.info("方法调用后:{}, 参数:{},返回:{},耗时:{}毫秒", methodName, JsonHelper.toJsonString(args),
          JsonHelper.toJsonString(res), System.currentTimeMillis() - start);
      return res;
    } catch (Throwable throwable) {
      logger.info("方法调用后:{}, 参数:{},异常:{},耗时:{}毫秒", methodName, JsonHelper.toJsonString(args),
          throwable.getClass(), System.currentTimeMillis() - start, throwable);
      throw throwable;
    }
  }
}
