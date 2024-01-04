package com.example.demo.repository;

import com.example.demo.form.GetForm;
import com.example.demo.form.PostForm;
import com.example.demo.form.PutForm;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Diary;
import java.util.List;

public interface IDiaryDao {

  // 登録されている日記を取得
  List<Diary> findList(GetForm form);

  // 日記を登録する
  int insert(PostForm form);

  // idを指定して日記を1件取得
  Diary findById(int id);

  // 日記を更新する
  int update(PutForm form);

  // 日記を削除する
  int delete(int id);
}