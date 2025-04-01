package com.ll.multiChat.domain.chat.chatRoom.entity;

import com.ll.multiChat.domain.chat.chatMessage.entity.ChatMessage;
import com.ll.multiChat.global.baseEntity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ChatRoom extends BaseEntity {

    private String name;

    @OneToMany
    private List<ChatMessage> chatMessages;
}
