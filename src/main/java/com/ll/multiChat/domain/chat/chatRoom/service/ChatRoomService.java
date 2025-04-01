package com.ll.multiChat.domain.chat.chatRoom.service;

import com.ll.multiChat.domain.chat.chatRoom.entity.ChatRoom;
import com.ll.multiChat.domain.chat.chatRoom.repository.ChatRoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ChatRoomService {
    private final ChatRoomRepository chatRoomRepository;

    public ChatRoom make (String name) {
        ChatRoom chatRoom = new ChatRoom();
        chatRoom.setName(name);
        chatRoomRepository.save(chatRoom);
        return chatRoom;
    }

    public List<ChatRoom> getList() {
        return chatRoomRepository.findAll();
    }
}
