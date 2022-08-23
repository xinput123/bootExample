package com.xinput.boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpecialCharacterController {

  @GetMapping("/sepcial")
  public String ss(@RequestParam("key") String key) {
    return key;
  }
}
