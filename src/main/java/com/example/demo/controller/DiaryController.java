package com.example.demo.controller;

import com.example.demo.form.PostForm;
import com.example.demo.form.PutForm;
import jakarta.validation.Valid;
import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.entity.Diary;
import com.example.demo.form.GetForm;
import com.example.demo.service.DiaryService;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/diary")
public class DiaryController {

  @Autowired
  private DiaryService diaryservice;

  /**
   * 日記アプリの一覧画面を表示
   *
   * @param model
   * @return resources/templates/list.html
   */
  @GetMapping
  public String diaryList(
      @ModelAttribute GetForm form,
      Model model
  ) {
    List<Diary> list = diaryservice.findList(form);
    model.addAttribute("list", list);
    model.addAttribute("getForm", form);
    return "init/list";
  }

  /**
   * 新規登録へ遷移
   *
   * @param model
   * @return resources/templates/new.html
   */
  @GetMapping("/new")
  public String formPage(
      Model model
  ) {
    return "init/new";
  }



  /**
   * 日記を新規登録
   *
   * @param postForm
   * @param model
   * @return
   */
  @PostMapping(path = "/insert", params = "insert")
  public String insert(
      @Valid @ModelAttribute PostForm form,
      BindingResult result,
      Model model
  ) {
    if (result.hasErrors()) {
      model.addAttribute("error", "パラメータエラーが発生しました。");
      return "init/new";
    }
    int count = diaryservice.insert(form);
    model.addAttribute("postForm", form);
    return "redirect:/diary";
  }

  /**
   * 一件タスクデータを取得し、詳細ページ表示
   *
   * @param id
   * @param model
   * @return resources/templates/detail.html
   */
  @GetMapping("/{id}")
  public String showUpdate(
      @PathVariable int id,
      Model model) {
    //Diaryを取得
    Optional<Diary> diaryOpl = Optional.ofNullable(diaryservice.findById(id));

    //NULLかどうかのチェック
    if (diaryOpl.isPresent()) {
      model.addAttribute("diary", diaryOpl.get());
      return "init/detail";
    } else {
      model.addAttribute("error", "対象データが存在しません");
      return "init/detail";
    }
  }

  /**
   * 日記を編集
   *
   * @param putForm
   * @param model
   * @return
   */
  @PostMapping(path = "/update", params = "update")
  public String update(
      @ModelAttribute PutForm form,
      BindingResult result,
      Model model
  ) {
    if (result.hasErrors()) {
      model.addAttribute("error", "パラメータエラーが発生しました。");
      return "init/edit";
    }
    int count = diaryservice.update(form);
    return "redirect:/diary";
  }

  /**
   * 新規登録へ遷移
   *
   * @param model
   * @return resources/templates/edit.html
   */
  @PostMapping("/new")
  public String formPageNew(
      @ModelAttribute PutForm form,
      Model model
  ) {
    model.addAttribute("putForm", form);
    //新規登録か編集で分岐
    if (form.isUpdateFlag()) {
      model.addAttribute("update", true);
    } else {
      model.addAttribute("update", false);
    }
    return "init/new";
  }
    /**
   * 新規登録へ遷移
   *
   * @param model
   * @return resources/templates/edit.html
   */
  @PostMapping("/edit")
  public String formPageEdit(
      @ModelAttribute PutForm form,
      Model model
  ) {
    model.addAttribute("putForm", form);
    //新規登録か編集で分岐
    if (form.isUpdateFlag()) {
      model.addAttribute("update", true);
    } else {
      model.addAttribute("update", false);
    }
    return "init/edit";
  }
  /**
   * 「一覧へ」選択時、一覧画面へ遷移
   *
   * @param model
   * @return resources/templates/list.html
   */
  @PostMapping(path = {"/insert", "/form", "/update"}, params = "back")
  public String backPage(
      Model model
  ) {
    return "redirect:/diary";
  }

  /**
   * 日記を削除
   * @param id
   * @param model
   * @return
   */
  @PostMapping("/delete")
  public String delete(
      @RequestParam int id,
      Model model
  ) {
    int count = diaryservice.delete(id);
    return "redirect:/diary";
  }
}
