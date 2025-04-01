package com.ll.multiChat.global.initData;


import com.ll.multiChat.domain.article.article.entity.Article;
import com.ll.multiChat.domain.article.article.service.ArticleService;
import com.ll.multiChat.domain.chat.chatMessage.service.ChatMessageService;
import com.ll.multiChat.domain.chat.chatRoom.service.ChatRoomService;
import com.ll.multiChat.domain.member.member.entity.Member;
import com.ll.multiChat.domain.member.member.service.MemberService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("!prod")
public class NotProd {

    @Bean
    public ApplicationRunner initNotProd(
            ChatRoomService chatRoomService,
            ChatMessageService chatMessageService,
            MemberService memberService,
            ArticleService articleService
    ){
        return args -> {
//            ChatRoom chatRoom1 = chatRoomService.make("공부");
//            ChatRoom chatRoom2 = chatRoomService.make("식사");
//            ChatRoom chatRoom3 = chatRoomService.make("휴식");
//
//            IntStream.rangeClosed(1, 100).forEach(num ->{
//                chatMessageService.write(chatRoom1, "홍길동", "공부 메세지" + num);
//            });
            Member member1 = memberService.join("짱구", "1234").getData();
//            Member member2 = memberService.join("철수", "1234").getData();
//            Member member3 = memberService.join("맹구", "1234").getData();

            Article article1 = articleService.write(member1.getId(), "첫번째 게시글", "내용1").getData();
//            Article article2 = articleService.write(member1.getId(), "두번째 게시글", "내용2").getData();
//
//            Article article3 = articleService.write(member2.getId(), "세번째 게시글", "내용3").getData();
//            Article article4 = articleService.write(member2.getId(), "네번째 게시글", "내용4").getData();
        };
    }
}
