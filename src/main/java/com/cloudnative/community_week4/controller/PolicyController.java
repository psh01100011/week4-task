package com.cloudnative.community_week4.controller;

import com.cloudnative.community_week4.service.PolicyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/api/v1/policy")
@RequiredArgsConstructor
public class PolicyController {

    private final PolicyService policyService;


    //이용약관
    @GetMapping("/terms")
    public String termsPage(Model model) throws Exception {
        String termsContent = policyService.getTermsContent();
        //모델에 담아 넘기기
        model.addAttribute("termsContent", termsContent);
        return "terms";
    }

    //개인정보
    @GetMapping("/privacy")
    public String privacyPage(Model model) throws Exception {
        String privacyContent = policyService.getPrivacyContent();
        model.addAttribute("privacyContent", privacyContent);
        return "privacy";
    }
}