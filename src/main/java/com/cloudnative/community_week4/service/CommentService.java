package com.cloudnative.community_week4.service;


import com.cloudnative.community_week4.dto.CommentDto;
import com.cloudnative.community_week4.dto.PostDto;
import com.cloudnative.community_week4.entity.Comment;
import com.cloudnative.community_week4.entity.Post;
import com.cloudnative.community_week4.entity.User;
import com.cloudnative.community_week4.repository.CommentRepository;
import com.cloudnative.community_week4.repository.PostRepository;
import com.cloudnative.community_week4.repository.UserRepository;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommentService {

    private final CommentRepository commentRepository;
    private final EntityManager entityManager;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    //댓글 작성
    @Transactional
    public CommentDto createComment(CommentDto commentRequest){
        //프록시 객체로 주입
        User user = entityManager.getReference(User.class, commentRequest.getUserId());
        Post post = entityManager.getReference(Post.class, commentRequest.getPostId());

        post.addCommentCount();

        Comment comment = commentRepository.save(new Comment(
                post,
                user,
                commentRequest.getContent()
        ));

        return new CommentDto(comment.getId(),
                post.getId(),
                user.getId(),
                user.getNickname(),
                comment.getContent(),
                comment.getCreatedAt(),
                comment.getUpdatedAt()
        );
    }

    //댓글 수정
    @Transactional
    public CommentDto updateComment(CommentDto commentRequest) {
        Comment comment = commentRepository.findById(commentRequest.getId()).orElseThrow(() -> new IllegalArgumentException("Post not found"));

        if (commentRequest.getContent() != null){
            comment.changeContent(commentRequest.getContent());
        }
        comment.setUpdatedAt(LocalDateTime.now());

        return new CommentDto(comment.getId(),
                comment.getPost().getId(),
                comment.getUser().getId(),
                comment.getUser().getNickname(),
                comment.getContent(),
                comment.getCreatedAt(),
                comment.getUpdatedAt()
        );
    }

    //댓글 삭제
    @Transactional
    public void deleteComment(Long id, Long postId){
        Post post = postRepository.findById(postId).orElseThrow(() -> new IllegalArgumentException("Post not found"));

        post.minusCommentCount();

        commentRepository.deleteById(id);
    }

    //댓글 목록 조회 : 댓글도 페이징 적용해야 할 것 같은데, 일단 간단하게 구현? -> 일단 단순 목록 조회 구현
    public List<CommentDto> getCommentList(Long postId){
        List<Comment> comments = commentRepository.findByPostIdOrderByIdDesc(postId);

        return comments.stream()
                .map(comment -> new CommentDto(
                        comment.getId(),
                        comment.getPost().getId(),
                        comment.getUser().getId(),
                        comment.getUser().getNickname(),
                        comment.getContent(),
                        comment.getCreatedAt(),
                        comment.getUpdatedAt()
                ))
                .toList();
    }
}
