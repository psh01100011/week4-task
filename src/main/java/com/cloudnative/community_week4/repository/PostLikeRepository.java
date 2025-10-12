package com.cloudnative.community_week4.repository;

import com.cloudnative.community_week4.entity.PostLike;
import com.cloudnative.community_week4.entity.PostLikeId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostLikeRepository extends JpaRepository<PostLike, PostLikeId> {
    boolean existsByPostIdAndUserId(Long postId, Long userId);
    void deleteByPostIdAndUserId(Long postId, Long userId);
}