package com.xinput.boot.gof.strategy.context;

import com.xinput.boot.gof.strategy.consts.RewardTypeEnum;
import com.xinput.boot.gof.strategy.service.IRewardStrategy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class StrategyFactory implements InitializingBean, ApplicationContextAware {

  private static final Map<RewardTypeEnum, IRewardStrategy> strategyMap = new ConcurrentHashMap();

  private ApplicationContext applicationContext;

  @Override
  public void afterPropertiesSet() throws Exception {
    // 注册到spring中
    applicationContext.getBeansOfType(IRewardStrategy.class).values().forEach(
        fileStrategy -> strategyMap.put(fileStrategy.getRewardTypeEnum(), fileStrategy)
    );
  }

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    this.applicationContext = applicationContext;
  }

  public IRewardStrategy getRewardStrategy(RewardTypeEnum fileTypeResolveEnum) {
    return strategyMap.get(fileTypeResolveEnum);
  }
}
