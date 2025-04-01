package com.ll.multiChat.domain.chat.chatMessage.service;

import com.ll.multiChat.domain.chat.chatMessage.entity.ChatMessage;
import com.ll.multiChat.domain.chat.chatMessage.repository.ChatMessageRepository;
import com.ll.multiChat.domain.chat.chatRoom.entity.ChatRoom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatMessageService {
    private final ChatMessageRepository chatMessageRepository;


    public void write(ChatRoom chatRoom, String writeName, String content) {
        ChatMessage chatMessage = new ChatMessage();

        chatMessage.setChatRoom(chatRoom);
        chatMessage.setWriteName(writeName);
        chatMessage.setContent(content);

        chatMessageRepository.save(chatMessage);
    }

}
