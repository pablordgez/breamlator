package es.pablordgz.breamlator.repositories.Language;

import es.pablordgz.breamlator.entities.Language;
import es.pablordgz.breamlator.repositories.AI.registries.AIRepositoryRegistryImpl;
import es.pablordgz.breamlator.services.translation.AITranslationService;
import es.pablordgz.breamlator.services.translation.TranslationService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("languageRepositoryImpl")
public class InMemoryLanguageRepository implements LanguageRepository {

    private List<Language> languages;

    @PostConstruct
    public void init() {
        languages = new ArrayList<>();
        TranslationService translationService = new AITranslationService(new AIRepositoryRegistryImpl());
        languages.add(new Language("Old English", "Shakespeare English", "AI"));
        languages.add(new Language("Pirate", "Talk like a pirate", "AI"));
        languages.add(new Language("Poetry", "Talk using rhymes", "AI"));
        languages.add(new Language("Jar Jar Binks", "Talk like Jar Jar Binks", "AI"));
        languages.add(new Language("Yoda", "Talk like Yoda", "AI"));
        languages.add(new Language("Gollum", "Talk like Gollum", "AI"));
        languages.add(new Language("Anime girl", "Talk like an anime girl", "AI"));
        languages.add(new Language("Secret", "Talk like you are trying very hard to keep a secret", "AI"));
        languages.add(new Language("Paranoid", "Talk like you are paranoid about secret agencies investigating you", "AI"));
        languages.add(new Language("Chicote", "Talk like Alberto Chicote in the Spanish TV Show Pesadilla en la Cocina", "AI"));
        languages.add(new Language("Rajoy", "Talk like Spanish politician Mariano Rajoy", "AI"));
        languages.add(new Language("Rapper", "Talk like a rapper", "AI"));
        languages.add(new Language("Rajoy v2", "Talk like Spanish politician Mariano Rajoy. Make sure to use some messy and non sensical sentences like he does", "AI"));
        languages.add(new Language("Teletienda", "Talk like you are a salesman on a TV home shopping network", "AI"));
        languages.add(new Language("Caveman", "Talk like a caveman, make sure to use some grunts. Use vocabulary related to prehistory", "AI"));
        languages.add(new Language("Donald Trump", "Talk like Donald Trump", "AI"));
        languages.add(new Language("Gen Z", "Talk like a gen Z person, using gen Z slang", "AI"));
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
