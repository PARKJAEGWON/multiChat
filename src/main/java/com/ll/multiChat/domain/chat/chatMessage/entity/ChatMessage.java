package com.ll.multiChat.domain.chat.chatMessage.entity;


import com.ll.multiChat.domain.chat.chatRoom.entity.ChatRoom;
import com.ll.multiChat.global.baseEntity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ChatMessage extends BaseEntity {

    @ManyToOne
    private ChatRoom chatRoom;

    private String writeName;

    private String content;


}
