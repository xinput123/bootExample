package com.xinput.boot.gof.strategy.controller;

import com.xinput.boot.gof.strategy.consts.RewardTypeEnum;
import com.xinput.boot.gof.strategy.context.StrategyFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/strategy")
public class StrategyController {

  @Resource
  private StrategyFactory strategyFactory;

  @GetMapping("/status")
  public String status() {
    return "ok";
  }

  @GetMapping("/desc/{id}")
  public String desc(@PathVariable(name = "id") int id) {
    RewardTypeEnum rewardTypeEnum = RewardTypeEnum.getRewardTypeEnum(id);
    if (rewardTypeEnum == null) {
      return "参数不对, id=" + id;
    }
    return strategyFactory.getRewardStrategy(rewardTypeEnum).rewardDetail();
  }
}
