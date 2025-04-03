package com.ll.multiChat.domain.article.article.service;

import com.ll.multiChat.domain.article.article.entity.Article;
import com.ll.multiChat.domain.article.article.repository.ArticleRepository;
import com.ll.multiChat.domain.article.articleComment.entity.ArticleComment;
import com.ll.multiChat.domain.member.member.entity.Member;
import com.ll.multiChat.global.config.RsData;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

//@Transactional(readOnly = true)
@Transactional
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

    @Transactional//트랜잭션이 적용되면 영속성 컨텍스트 내에서 엔티티 변경을 감지(더티 체킹)하여 자동으로 DB에 반영됨
    public void modifyComment(ArticleComment comment, String commentBody) {
        comment.setBody(commentBody); // 필드 값 변경 → 트랜잭션 종료 시 자동으로 업데이트됨
    }

    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    public Page<Article> search(List<String> kwTypes,String kw, Pageable pageable){
        return articleRepository.search(kwTypes, kw, pageable);
    }
}
