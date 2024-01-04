package com.example.demo.entity;

import java.io.Serializable;
import lombok.Data;

@Data
public class User implements Serializable {
  private int id;
  private String userId;
  private String password;
  private String name;

}