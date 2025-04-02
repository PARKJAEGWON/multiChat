package com.ll.multiChat.domain.article.articleComment.service;

import com.ll.multiChat.domain.article.article.repository.ArticleRepository;
import com.ll.multiChat.domain.article.articleComment.entity.ArticleComment;
import com.ll.multiChat.domain.article.articleComment.repository.ArticleCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleCommentService {
    private final ArticleCommentRepository articleCommentRepository;

    public List<ArticleComment> findByAuthorId(Long id){
        return articleCommentRepository.findByAuthorId(id);
    }
}
