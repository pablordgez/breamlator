package es.pablordgz.breamlator.services.translation.registry;

import es.pablordgz.breamlator.repositories.AI.registries.AIRepositoryRegistryImpl;
import es.pablordgz.breamlator.services.translation.AITranslationService;
import es.pablordgz.breamlator.services.translation.TranslationService;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class TranslationServiceRegistryImpl implements TranslationServiceRegistry {

    private final HashMap<String, TranslationService> translationServices = new HashMap<>();

    public TranslationServiceRegistryImpl() {
        translationServices.put("AI", new AITranslationService(new AIRepositoryRegistryImpl()));
    }

    @Override
    public TranslationService getTranslationServiceByName(String name) {
        if (translationServices.containsKey(name)) {
            return translationServices.get(name);
        }
        return null;
    }
}
