package es.pablordgz.breamlator.services.language;

import es.pablordgz.breamlator.entities.Language;
import es.pablordgz.breamlator.repositories.Language.LanguageRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LanguageService {
    private final LanguageRepository languageRepository;

    public LanguageService(@Qualifier("languageRepositorySQL") LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    public Language getLanguageByName(String name) {
        return languageRepository.findByName(name);
    }

    public List<String> getAllLanguageNames() {
        List<String> languageNames = new ArrayList<>();
        for (Language language : languageRepository.findAll()) {
            languageNames.add(language.getName());
        }
        return languageNames;
    }
}
