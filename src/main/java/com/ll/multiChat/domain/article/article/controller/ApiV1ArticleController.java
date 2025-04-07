package com.ll.multiChat.domain.article.article.controller;

import com.ll.multiChat.domain.article.article.dto.ArticleDto;
import com.ll.multiChat.domain.article.article.dto.ArticleModifyRequest;
import com.ll.multiChat.domain.article.article.dto.ArticleWriteRequest;
import com.ll.multiChat.domain.article.article.entity.Article;
import com.ll.multiChat.domain.article.article.service.ArticleService;
import com.ll.multiChat.global.config.RsData;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/articles")
public class ApiV1ArticleController {
    private final ArticleService articleService;

    @GetMapping
    public List<ArticleDto> getArticles(){
        List<Article> articles = articleService.findAll();

        List<ArticleDto> articleDtoList = articles.stream()
                .map(ArticleDto::new)
                .toList();
        return articleDtoList;
    }
    @GetMapping("/{id}")
    private ArticleDto getArticle(@PathVariable("id")Long id) {
        Article article = articleService.findById(id).orElse(null);
        ArticleDto articleDto = new ArticleDto(article);
        return articleDto;
    }


    @PostMapping
    public RsData<ArticleDto> writeArticle(@Valid @RequestBody ArticleWriteRequest articleWriteRequest){
        Article article = articleService.write(articleWriteRequest.getTitle(), articleWriteRequest.getContent());

        return RsData.of("200", "게시글 생성 완료",new ArticleDto(article));
    }

    @PatchMapping("/{id}")
    public RsData<ArticleDto> updateArticle(@PathVariable("id")Long id,@Valid @RequestBody ArticleModifyRequest articleModifyRequest){

        Article article = this.articleService.findById(id).orElse(null);

        Article modifiedArticle =this.articleService.modify(article, articleModifyRequest.getTitle(), articleModifyRequest.getContent());

        return RsData.of("200", "게시글 수정 완료",new ArticleDto(modifiedArticle));
    }

    @DeleteMapping("/{id}")
    public RsData<Void> deleteArticle(@PathVariable("id")Long id){
        this.articleService.delete(id);
        return RsData.of("200", "게시글 삭제 완료",null);

    }
}
