package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookMapper {
  //1件検索
//  @Select("SELECT id, book_name, volume_num, author_name, published_date FROM booktable WHERE id = #{id}")
//  Book findById(Book book);

  //全件取得
//  @Select("SELECT id, book_name, volume_num, author_name, published_date FROM booktable")
//  List<Book> findAll();
}
