package com.ll.multiChat.domain.chat.chatRoom.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QChatRoom is a Querydsl query type for ChatRoom
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QChatRoom extends EntityPathBase<ChatRoom> {

    private static final long serialVersionUID = -216464563L;

    public static final QChatRoom chatRoom = new QChatRoom("chatRoom");

    public final com.ll.multiChat.global.baseEntity.QBaseEntity _super = new com.ll.multiChat.global.baseEntity.QBaseEntity(this);

    public final ListPath<com.ll.multiChat.domain.chat.chatMessage.entity.ChatMessage, com.ll.multiChat.domain.chat.chatMessage.entity.QChatMessage> chatMessages = this.<com.ll.multiChat.domain.chat.chatMessage.entity.ChatMessage, com.ll.multiChat.domain.chat.chatMessage.entity.QChatMessage>createList("chatMessages", com.ll.multiChat.domain.chat.chatMessage.entity.ChatMessage.class, com.ll.multiChat.domain.chat.chatMessage.entity.QChatMessage.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createDate = _super.createDate;

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifyDate = _super.modifyDate;

    public final StringPath name = createString("name");

    public QChatRoom(String variable) {
        super(ChatRoom.class, forVariable(variable));
    }

    public QChatRoom(Path<? extends ChatRoom> path) {
        super(path.getType(), path.getMetadata());
    }

    public QChatRoom(PathMetadata metadata) {
        super(ChatRoom.class, metadata);
    }

}

