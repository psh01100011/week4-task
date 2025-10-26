package com.cloudnative.community_week4.service;


import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;

@Service
public class PolicyService {

    public String getTermsContent() throws IOException {
        return readFileFromResource("policy/terms.txt");
    }

    public String getPrivacyContent() throws IOException {
        return readFileFromResource("policy/privacy.txt");
    }

    private String readFileFromResource(String path) throws IOException {
        ClassPathResource resource = new ClassPathResource(path);
        return Files.readString(resource.getFile().toPath());
    }
}