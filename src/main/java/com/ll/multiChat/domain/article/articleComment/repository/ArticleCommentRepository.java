package com.ll.multiChat.domain.article.articleComment.repository;

import com.ll.multiChat.domain.article.articleComment.entity.ArticleComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleCommentRepository extends JpaRepository<ArticleComment, Long> {
    List<ArticleComment> findByArticleId(Long articleId);

    List<ArticleComment> findByAuthorId(Long id);
}
