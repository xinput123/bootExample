package com.xinput.boot.gof.strategy.service;

import com.xinput.boot.gof.strategy.consts.RewardTypeEnum;

/**
 * 策略模式
 */
public interface IRewardStrategy {

  RewardTypeEnum getRewardTypeEnum();

  String rewardDetail();
}
