package com.cloudnative.community_week4.repository;

import com.cloudnative.community_week4.entity.PostContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostContentRepository extends JpaRepository<PostContent, Long> {
}
