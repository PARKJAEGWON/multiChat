package com.ll.multiChat.domain.article.articleTag.entity;

import com.ll.multiChat.domain.article.article.entity.Article;
import com.ll.multiChat.global.baseEntity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ArticleTag extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private Article article;
    private String content;


}
