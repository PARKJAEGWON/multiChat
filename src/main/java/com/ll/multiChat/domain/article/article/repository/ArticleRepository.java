package com.ll.multiChat.domain.article.article.repository;

import com.ll.multiChat.domain.article.article.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long>, ArticleRepositoryCustom {
    List<Article> findByOrderByIdDesc();
}
