package es.pablordgz.breamlator.controllers;

import es.pablordgz.breamlator.services.language.LanguageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LanguageController {

    private final LanguageService languageService;

    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @RequestMapping(value = "/language/list")
    public List<String> getLanguages() {
        return languageService.getAllLanguageNames();
    }
}
