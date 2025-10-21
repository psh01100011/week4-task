package com.cloudnative.community_week4.service;

import com.cloudnative.community_week4.dto.PostDto;
import com.cloudnative.community_week4.repository.PostContentRepository;
import com.cloudnative.community_week4.repository.PostRepository;
import com.cloudnative.community_week4.repository.UserRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class PostServiceTest {

    @InjectMocks
    private PostService postService;

    @Mock
    private PostRepository postRepository;
    @Mock
    private PostContentRepository postContentRepository;
    @Mock
    private UserRepository userRepository;
    @Mock
    private EntityManager entityManager;


    @Test
    public void createPost(){

    }


}