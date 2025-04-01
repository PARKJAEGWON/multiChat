package com.ll.multiChat.domain.article.article.entity;

import com.ll.multiChat.domain.member.member.entity.Member;
import com.ll.multiChat.global.baseEntity.BaseEntity;
import jakarta.persistence.Entity;
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
public class Article extends BaseEntity {
    private String title;
    private String content;

    @ManyToOne
    private Member author;
}
