package com.ll.multiChat.domain.article.article.controller;

import com.ll.multiChat.domain.article.article.entity.Article;
import com.ll.multiChat.domain.article.article.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/article")
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;

    @GetMapping("/list")
    public String list(@RequestParam(value = "page", defaultValue = "0") int page, Model model) {
        List<Sort.Order> sorts = new ArrayList<>(); // 정렬 조건을 저장할 리스트 생성
        sorts.add(Sort.Order.desc("id")); // id를 기준으로 내림차순 정렬 추가
        // 페이지네이션과 정렬 정보를 포함한 Pageable 객체 생성 (페이지 번호, 페이지 크기, 정렬 정보)
        Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));

        Page<Article> itemsPage = articleService.search(pageable);
        model.addAttribute("itemsPage", itemsPage);
        return "article/list";
    }
}
