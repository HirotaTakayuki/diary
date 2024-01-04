package com.example.demo.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Tutorial {

  @After("execution(String *..*AopController.logtest*(..))")
  public void logoutput() {
    System.out.println("test1");
//    TODO 日本語だと文字化けする
    System.out.println("test2");
  }
}