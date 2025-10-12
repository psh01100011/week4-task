package com.cloudnative.community_week4.entity;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

//복합키 클래스를 위해 생성

@EqualsAndHashCode
public class PostLikeId implements Serializable {
    private Long post;
    private Long user;
}