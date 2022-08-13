package com.xinput.boot.gof.strategy.service.impl;

import com.xinput.boot.gof.strategy.consts.RewardTypeEnum;
import com.xinput.boot.gof.strategy.service.IRewardStrategy;
import org.springframework.stereotype.Component;

/**
 * 现金 类型策略具体实现
 */
@Component
public class BonusRewardService implements IRewardStrategy {
  @Override
  public RewardTypeEnum getRewardTypeEnum() {
    return RewardTypeEnum.BONUS;
  }

  @Override
  public String rewardDetail() {
    return "贡献获得10元现金";
  }
}
