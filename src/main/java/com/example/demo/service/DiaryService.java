package com.example.demo.service;


import com.example.demo.form.GetForm;
import com.example.demo.form.PostForm;
import com.example.demo.form.PutForm;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.repository.IDiaryDao;
import com.example.demo.entity.Diary;


@Service
@Transactional
public class DiaryService {

  private final IDiaryDao dao;

  @Autowired
  public DiaryService(IDiaryDao dao) {
    this.dao = dao;
  }

  public List<Diary> findList(GetForm form) {
    return dao.findList(form);
  }

  public int insert(PostForm form) {
    return dao.insert(form);
  }

  public Diary findById(int id) {
    try {
      return dao.findById(id);
    } catch(IncorrectResultSizeDataAccessException e) {
      return null;
    }
  }

  public int update(PutForm form) {
    return dao.update(form);
  }

  public int delete(int id) {
    return dao.delete(id);
  }
}