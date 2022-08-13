package com.xinput.boot.gof.chain.controller;

import com.xinput.boot.gof.chain.dto.Request;
import com.xinput.boot.gof.chain.dto.Response;
import com.xinput.boot.gof.chain.handler.ChainPatternDemo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/chain")
public class ChainController {

  @Resource
  private ChainPatternDemo chainPatternDemo;

  @GetMapping("/check")
  public String check() {
    chainPatternDemo.exec(new Request(), new Response());
    return "ok";
  }
}
