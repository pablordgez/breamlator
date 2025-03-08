package es.pablordgz.breamlator.services.language;

import es.pablordgz.breamlator.entities.Language;
import es.pablordgz.breamlator.repositories.Language.LanguageRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class LanguageService {
    private final LanguageRepository languageRepository;

    public LanguageService(@Qualifier("languageRepositoryImpl") LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    public Language getLanguageByName(String name) {
        return languageRepository.findByName(name);
    }
}
