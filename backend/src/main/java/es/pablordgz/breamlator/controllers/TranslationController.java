package es.pablordgz.breamlator.controllers;

import es.pablordgz.breamlator.entities.Language;
import es.pablordgz.breamlator.services.language.LanguageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TranslationController {

    private final LanguageService languageService;

    public TranslationController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @RequestMapping(value = "/translate", method = RequestMethod.POST)
    public String translate(@RequestParam("language") String language, @RequestParam("text") String text, @RequestParam Map<String, String> extraParams) {
        Language lang = languageService.getLanguageByName(language);
        if (lang == null) {
            return "The language " + language + " does not exist";
        } else {
            return lang.getTranslationService().translate(text, lang.getDescription(), extraParams);
        }
    }
}
