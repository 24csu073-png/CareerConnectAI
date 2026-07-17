package com.careerconnect.ai.controller;

import com.careerconnect.ai.dto.PromptRequest;
import com.careerconnect.ai.dto.PromptResponse;
import com.careerconnect.ai.service.AIService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ai")
@CrossOrigin(origins = "*")
public class AIController {

    private final AIService aiService;

    public AIController(AIService aiService) {
        this.aiService = aiService;
    }

    @PostMapping("/chat")
    public PromptResponse chat(@RequestBody PromptRequest request) {

        String response = aiService.askAI(request.getPrompt());

        return new PromptResponse(response);
    }
}