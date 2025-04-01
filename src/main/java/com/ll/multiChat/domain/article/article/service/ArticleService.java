package com.ll.multiChat.domain.article.article.service;

import com.ll.multiChat.domain.article.article.entity.Article;
import com.ll.multiChat.domain.article.article.repository.ArticleRepository;
import com.ll.multiChat.domain.member.member.entity.Member;
import com.ll.multiChat.global.config.RsData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;
// 이걸 사용시에는 따로 memberId를 호출할 수 있는 생성자를 만들어줘야 쓸 수 있음
//    public RsData<Article> write(Long memberId, String title, String content){
//
//        Member member = new Member();
//        member.setId(memberId);
//
//        Article article = new Article();
//        article.setMember(memberId);
//        article.setTitle(title);
//        article.setContent(content);
//        articleRepository.save(article);
//        return RsData.of("200", "게시글 작성 완료",article);
//    }
    public RsData<Article> write(Long memberId, String title, String content){
        Article article = Article.builder()
                .author(Member.builder().id(memberId).build())
                .title(title)
                .content(content)
                .build();

        articleRepository.save(article);
    return RsData.of("200", "게시글 작성 완료", article);
    }

    public Optional<Article> findById(Long id){
//        원래 findById는 Optional를 해야함 간단한 처리라 .get으로 가져옴 이런 방법도 있음
//        Article article = articleRepository.findById(id).get();
//
//        return article;
        return articleRepository.findById(id);
    }

    @Transactional
    public void modify(Article article, String title, String content){
        article.setTitle(title);
        article.setContent(content);

        articleRepository.save(article);
    }
}
