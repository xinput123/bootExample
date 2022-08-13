package com.xinput.boot.gof.strategy.service.impl;

import com.xinput.boot.gof.strategy.consts.RewardTypeEnum;
import com.xinput.boot.gof.strategy.service.IRewardStrategy;
import org.springframework.stereotype.Component;

/**
 * 默认 类型策略具体实现
 */
@Component
public class DefaultRewardService implements IRewardStrategy {
  @Override
  public RewardTypeEnum getRewardTypeEnum() {
    return RewardTypeEnum.DEFAULT_REWARD;
  }

  @Override
  public String rewardDetail() {
    return RewardTypeEnum.DEFAULT_REWARD.getDesc();
  }
}
