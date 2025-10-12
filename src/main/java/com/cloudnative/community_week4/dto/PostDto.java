package com.cloudnative.community_week4.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class PostDto {
    private Long id;
    private Long userId;
    private String nickname;
    private String title;
    private String content;
    private String image;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public PostDto(Long id){
        this.id = id;
    }

    public PostDto(Long id, Long userId, String nickname, String title, String content, String image, LocalDateTime createdAt, LocalDateTime updatedAt){
        this.id = id;
        this.userId = userId;
        this.nickname = nickname;
        this.title = title;
        this.content = content;
        this.image = image;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public void setUserId(Long userId){
        this.userId = userId;
    }

    public void setPostId(Long postId){
        this.id = postId;
    }
}
