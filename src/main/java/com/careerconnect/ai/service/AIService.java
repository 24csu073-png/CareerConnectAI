package com.careerconnect.ai.service;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class AIService {

    @Value("${gemini.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();


    public String askAI(String prompt) {

    	String url =
    			"https://generativelanguage.googleapis.com/v1beta/models/gemini-3.5-flash:generateContent?key="
    			        + apiKey;


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);


        Map<String, Object> body = Map.of(
                "contents",
                List.of(
                        Map.of(
                                "parts",
                                List.of(
                                        Map.of("text", prompt)
                                )
                        )
                )
        );


        HttpEntity<Map<String,Object>> request =
                new HttpEntity<>(body, headers);


        ResponseEntity<JsonNode> response =
                restTemplate.exchange(
                        url,
                        HttpMethod.POST,
                        request,
                        JsonNode.class
                );


        return response.getBody()
                .path("candidates")
                .get(0)
                .path("content")
                .path("parts")
                .get(0)
                .path("text")
                .asText();
    }
}