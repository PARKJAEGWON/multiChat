package com.ll.multiChat.domain.article.articleTag.repository;

import com.ll.multiChat.domain.article.articleTag.entity.ArticleTag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleTagRepository extends JpaRepository<ArticleTag, Long> {
    List<ArticleTag> findByArticle_authorId(Long authorId);

    List<ArticleTag> findByArticle_authorUsername(String authorUsername);
}
