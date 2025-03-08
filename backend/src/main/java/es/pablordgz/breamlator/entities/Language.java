package es.pablordgz.breamlator.entities;

import es.pablordgz.breamlator.services.translation.TranslationService;

public class Language {
    private final String name;
    private final String description;
    private final TranslationService translationService;

    public Language(String name, String description, TranslationService translationService) {
        this.name = name;
        this.description = description;
        this.translationService = translationService;
    }

    public TranslationService getTranslationService() {
        return translationService;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }


}
