package com.cloudnative.community_week4.controller;

import com.cloudnative.community_week4.dto.AuthDto;
import com.cloudnative.community_week4.service.UserAuthService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    /*
    Todo :
     세션 사용시 세션을 저장하고 있을 데이터베이스가 필요한 거 아닌가? (일단은 단순하게 구현)
     -> 학습 후 추가하기
     */

    private final UserAuthService userAuthService;

    //로그인 후 세션 전달
    @PostMapping
    public ResponseEntity<String> login(@RequestBody AuthDto request, HttpSession session) {
        Long userId = userAuthService.login(request.getEmail(), request.getPassword());
        session.setAttribute("userId", userId);
        return ResponseEntity.status(HttpStatus.CREATED).body("로그인 성공");
    }

    //로그아웃 후 세션 삭제
    @DeleteMapping
    public ResponseEntity<String> logout(HttpSession session) {
        session.invalidate();
        return ResponseEntity.ok("로그아웃 완료");
    }


}