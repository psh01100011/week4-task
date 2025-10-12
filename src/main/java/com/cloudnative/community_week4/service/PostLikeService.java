package com.cloudnative.community_week4.service;

import com.cloudnative.community_week4.entity.Post;
import com.cloudnative.community_week4.entity.PostLike;
import com.cloudnative.community_week4.entity.User;
import com.cloudnative.community_week4.repository.PostLikeRepository;
import com.cloudnative.community_week4.repository.PostRepository;
import com.cloudnative.community_week4.repository.UserRepository;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class PostLikeService {

    private final PostLikeRepository postLikeRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final EntityManager entityManager;

    //좋아요
    public void likePost(Long postId, Long userId) {
        if (postLikeRepository.existsByPostIdAndUserId(postId, userId)) {
            throw new IllegalStateException("이미 좋아요를 누른 게시물입니다.");
        }

        Post post = entityManager.getReference(Post.class, postId);
        User user = entityManager.getReference(User.class, userId);

        postLikeRepository.save(new PostLike(post, user));
        post.minusLikeCount();  // post 엔티티에 likeCount++ 메서드 만들어두면 깔끔
    }

    //좋아요 취소
    public void unlikePost(Long postId, Long userId) {
        if (!postLikeRepository.existsByPostIdAndUserId(postId, userId)) {
            throw new IllegalStateException("좋아요를 누르지 않은 게시물입니다.");
        }

        postLikeRepository.deleteByPostIdAndUserId(postId, userId);
        Post post = entityManager.getReference(Post.class, postId);
        post.minusLikeCount(); // 좋아요 취소 시 감소
    }
}