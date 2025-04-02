package com.ll.multiChat.domain.article.article.entity;

import com.ll.multiChat.domain.article.articleComment.entity.ArticleComment;
import com.ll.multiChat.domain.article.articleTag.entity.ArticleTag;
import com.ll.multiChat.domain.member.member.entity.Member;
import com.ll.multiChat.global.baseEntity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Article extends BaseEntity {
    private String title;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY) //디폴트가 fetchtype eager 즉시 모드 |매니 투 원도 레이지모드로 설정해주면 좋다는데 더 공부해야함
    private Member author;
    //디폴트가 fetchtype lazy 지연 모드 Cascoade부모가 삭제되면 자식도 삭제됨 oprhanRemoval 자식요소가 삭제되면 삭제를 시킨다는데..다시 공부해야할듯 이해안감
    @OneToMany(mappedBy = "article",cascade = CascadeType.ALL,orphanRemoval = true)
    @Builder.Default
    private List<ArticleComment> comments = new ArrayList<>();
//    public void addComment(Member memberAuthor, String commentBody) {
//        ArticleComment comment = ArticleComment.builder()
//                .article(this)
//                .author(memberAuthor)
//                .body(commentBody)
//                .build();
//        comments.add(comment);
//    }

    public void addComment(Member memberAuthor, String commentBody) {
        ArticleComment comment = new ArticleComment();
        comment.setArticle(this);
        comment.setAuthor(memberAuthor);
        comment.setBody(commentBody);

        comments.add(comment);
    }

    public void removeComment(ArticleComment articleComment) {
        comments.remove(articleComment);
    }

    @OneToMany(mappedBy = "article",cascade = CascadeType.ALL,orphanRemoval = true)
    @Builder.Default
    private List<ArticleTag> tags = new ArrayList<>();

    public void addTag(String content){

        ArticleTag articleTag = new ArticleTag();
        articleTag.setArticle(this);
        articleTag.setContent(content);

        tags.add(articleTag);
    }
    public void addTags(String... tagContents) {

        for (String tagContent : tagContents) {
            addTag(tagContent);
        }
    }

//    public String getTagsStr() {
//        String tagsStr = tags
//                .stream()
//                .map(ArticleTag::getContent)
//                .collect(Collectors.joining(" #"));
//        if (tagsStr.isBlank()) {
//            return "";
//        }
//        return "#" + tagsStr;
//    }

    public String getTagsStr() {
        //만약 태그가 널 이거나 없으면 빈문자열
        if (tags == null || tags.isEmpty()) {
            return "";
        }

        StringBuilder tagsStr = new StringBuilder();
        //향상된 포문 태그의 숫자 만큼 돌려서 앞에 # 붙여주기
        for (ArticleTag tag : tags) {
            if (tagsStr.length() > 0) {
                tagsStr.append(" #");
            }
            tagsStr.append(tag.getContent());
        }
        return "#" + tagsStr.toString();//첫번째는 #이 없으니까 # 하드코딩으로 달아주기
    }
}
