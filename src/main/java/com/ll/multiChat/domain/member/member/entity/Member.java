package com.ll.multiChat.domain.member.member.entity;

import com.ll.multiChat.global.baseEntity.BaseEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Member extends BaseEntity {

    String username;

    String password;
}
