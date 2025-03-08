package es.pablordgz.breamlator.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Language {

    @GeneratedValue
    @Id
    private long id;
    private String name;
    private String description;
    private String translationService;

    public Language() {

    }

    public Language(String name, String description, String translationService) {
        this.name = name;
        this.description = description;
        this.translationService = translationService;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTranslationService() {
        return translationService;
    }

    public void setTranslationService(String translationService) {
        this.translationService = translationService;
    }
}
