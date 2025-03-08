package es.pablordgz.breamlator.services.translation.registry;

import es.pablordgz.breamlator.services.translation.TranslationService;
import org.springframework.stereotype.Repository;

@Repository
public interface TranslationServiceRegistry {
    TranslationService getTranslationServiceByName(String name);
}
