package com.xinput.boot.gof.strategy.consts;

import java.util.Arrays;

public enum RewardTypeEnum {
  DEFAULT_REWARD(0, "默认奖励,什么都没有"),
  BONUS(1, "现金奖励"),
  VOUCHER(2, "代金券奖励");

  private int type;
  private String desc;

  RewardTypeEnum(int type, String desc) {
    this.type = type;
    this.desc = desc;
  }

  public int getType() {
    return type;
  }

  public String getDesc() {
    return desc;
  }

  public static RewardTypeEnum getRewardTypeEnum(int rewardType) {
    return Arrays.stream(RewardTypeEnum.values())
        .filter(rewardTypeEnum -> rewardTypeEnum.getType() == rewardType)
        .findFirst()
        .orElse(null);
  }
}
