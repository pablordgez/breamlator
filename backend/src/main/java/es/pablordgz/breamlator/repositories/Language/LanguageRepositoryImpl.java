package es.pablordgz.breamlator.repositories.Language;

import es.pablordgz.breamlator.entities.Language;
import es.pablordgz.breamlator.repositories.AI.GeminiAIRepository;
import es.pablordgz.breamlator.services.translation.AITranslationService;
import es.pablordgz.breamlator.services.translation.TranslationService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LanguageRepositoryImpl implements LanguageRepository {

    private List<Language> languages;

    @PostConstruct
    public void init() {
        languages = new ArrayList<>();
        TranslationService translationService = new AITranslationService(new GeminiAIRepository());
        languages.add(new Language("Old English", "Shakespeare English", translationService));
        languages.add(new Language("Pirate", "Talk like a pirate", translationService));
        languages.add(new Language("Poetry", "Talk using rhymes", translationService));
        languages.add(new Language("Jar Jar Binks", "Talk like Jar Jar Binks", translationService));
        languages.add(new Language("Yoda", "Talk like Yoda", translationService));
        languages.add(new Language("Gollum", "Talk like Gollum", translationService));
        languages.add(new Language("Anime girl", "Talk like an anime girl", translationService));
        languages.add(new Language("Secret", "Talk like you are trying very hard to keep a secret", translationService));
        languages.add(new Language("Paranoid", "Talk like you are paranoid about secret agencies investigating you", translationService));
        languages.add(new Language("Chicote", "Talk like Alberto Chicote in the Spanish TV Show Pesadilla en la Cocina", translationService));
        languages.add(new Language("Rajoy", "Talk like Spanish politician Mariano Rajoy", translationService));
        languages.add(new Language("Rapper", "Talk like a rapper", translationService));
        languages.add(new Language("Rajoy v2", "Talk like Spanish politician Mariano Rajoy. Make sure to use some messy and non sensical sentences like he does", translationService));
        languages.add(new Language("Teletienda", "Talk like you are a salesman on a TV home shopping network", translationService));
    }

    @Override
    public List<Language> findAll() {
        List<Language> returnList = new ArrayList<>();
        returnList.addAll(languages);
        return returnList;
    }

    @Override
    public Language findByName(String name) {
        for (Language language : languages) {
            if (language.getName().equals(name)) {
                return language;
            }
        }
        return null;
    }
}
