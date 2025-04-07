package com.ll.multiChat.domain.article.article.dto;

import com.ll.multiChat.domain.article.article.entity.Article;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ArticleDto {
    private final Long id;
    private final String title;
    private final String content;
    private final String author;
    private final LocalDateTime createdDate;
    private final LocalDateTime modifyedDate;

    public ArticleDto(Article article){
        this.id = article.getId();
        this.title = article.getTitle();
        this.content = article.getContent();
        this.author = article.getAuthor().getUsername();
        this.createdDate = article.getCreateDate();
        this.modifyedDate = article.getModifyDate();


    }
}
