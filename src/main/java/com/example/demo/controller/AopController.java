package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AopController {
  @GetMapping("/aoptest")
  public String logtest() {
    return " aoptest";
  }
}
