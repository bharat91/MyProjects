package com.learning.ai_chatbot.controller;

import com.learning.ai_chatbot.dto.ChatRequest;
import com.learning.ai_chatbot.service.OpenSourceAiService;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ChatController {

    @Autowired
    public OpenSourceAiService openSourceAiService;

    @PostMapping("/chat")
    public ResponseEntity<String> chat(@RequestBody ChatRequest chatRequest) {
        String prompt = chatRequest.getMessages().get(chatRequest.getMessages().size()-1).get("content");
        String response = openSourceAiService.sendPrompt(chatRequest.getMessages());
        return ResponseEntity.ok(response);
    }

}
