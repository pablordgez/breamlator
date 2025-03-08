package es.pablordgz.breamlator.controllers;

import es.pablordgz.breamlator.entities.Language;
import es.pablordgz.breamlator.services.language.LanguageService;
import es.pablordgz.breamlator.services.translation.TranslationService;
import es.pablordgz.breamlator.services.translation.registry.TranslationServiceRegistry;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TranslationController {

    private final LanguageService languageService;
    private final TranslationServiceRegistry translationServiceRegistry;

    public TranslationController(LanguageService languageService, @Qualifier("translationServiceRegistryImpl") TranslationServiceRegistry translationServiceRegistry) {
        this.languageService = languageService;
        this.translationServiceRegistry = translationServiceRegistry;
    }

    @RequestMapping(value = "/translate", method = RequestMethod.POST)
    public String translate(@RequestParam("language") String language, @RequestParam("text") String text, @RequestParam Map<String, String> extraParams) {
        Language lang = languageService.getLanguageByName(language);
        if (lang == null) {
            return "The language " + language + " does not exist";
        } else {
            TranslationService translationService = translationServiceRegistry.getTranslationServiceByName(lang.getTranslationService());
            if (translationService == null) {
                return "The message could not be retrieved";
            }
            return translationService.translate(text, lang.getDescription(), extraParams);
        }
    }
}
