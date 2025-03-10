package es.pablordgz.breamlator.controllers;

import es.pablordgz.breamlator.services.ai.AIService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class AIController {

    private final AIService aiService;

    public AIController(AIService aiService) {
        this.aiService = aiService;
    }

    @RequestMapping(value = "/ai/list")
    public List<String> list() {
        return aiService.listRepositories();
    }
}
