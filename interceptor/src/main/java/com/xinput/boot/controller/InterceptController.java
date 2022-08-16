package com.xinput.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InterceptController {

  @RequestMapping("/reqUrl")
  public String reqUrl() {
    return "success";
  }
}
