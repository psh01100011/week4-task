package com.cloudnative.community_week4.repository;

import com.cloudnative.community_week4.entity.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAuthRepository extends JpaRepository<UserAuth, Long> {

    boolean existsByEmail(String email);
    UserAuth findByEmail(String email);
}
