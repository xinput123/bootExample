package com.xinput.boot.controller;

import com.xinput.boot.config.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AopController {

  @Log
  @GetMapping("/log1")
  public String log1(@RequestParam("name") String name) {
    return "success：" + name;
  }

  @Log
  @GetMapping("/log2")
  public String log2(@RequestParam("name") String name) {
    int error = 100 / 0;
    System.out.println(error);
    return "success：" + name;
  }
}