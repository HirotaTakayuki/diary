package com.example.demo.entity;


import java.sql.Timestamp;
import java.io.Serializable;
import lombok.Data;

@Data
public class Diary implements Serializable {

  private int id;
  private String category;
  private String title;
  private String content;
  private String date;
  private Timestamp update_datetime;
  private String name;

}