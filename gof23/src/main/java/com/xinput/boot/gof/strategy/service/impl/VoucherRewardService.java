package com.xinput.boot.gof.strategy.service.impl;

import com.xinput.boot.gof.strategy.consts.RewardTypeEnum;
import com.xinput.boot.gof.strategy.service.IRewardStrategy;
import org.springframework.stereotype.Component;

/**
 * 代金券 类型策略具体实现
 */
@Component
public class VoucherRewardService implements IRewardStrategy {
  @Override
  public RewardTypeEnum getRewardTypeEnum() {
    return RewardTypeEnum.VOUCHER;
  }

  @Override
  public String rewardDetail() {
    return "恭喜获得50元代金券";
  }
}
