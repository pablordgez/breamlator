package es.pablordgz.breamlator.services.translation;

import es.pablordgz.breamlator.repositories.AI.AIRepository;
import es.pablordgz.breamlator.repositories.AI.registries.AIRepositoryRegistry;
import es.pablordgz.breamlator.utils.AITranslationContextBuilder;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Map;

public class AITranslationService implements TranslationService {

    private final AIRepositoryRegistry registry;

    public AITranslationService(@Qualifier("AIRepositoryRegistryImpl") AIRepositoryRegistry registry) {
        this.registry = registry;
    }

    @Override
    public String translate(String text, String language, Map<String, String> params) {
        if (!params.containsKey("AI_REPOSITORY")) {
            return "The message could not be translated";
        } else {
            AIRepository aiRepo = registry.getAIRepository(params.get("AI_REPOSITORY"));
            if (params.containsKey(aiRepo.getName() + "_API_KEY")) {
                return aiRepo.getMessage(text, AITranslationContextBuilder.getContext(language), params.get(aiRepo.getName() + "_API_KEY"));
            } else {
                if (!aiRepo.isAvailable()) {
                    return "The message could not be retrieved";
                }
                return aiRepo.getMessage(text, AITranslationContextBuilder.getContext(language));
            }
        }
    }

}
