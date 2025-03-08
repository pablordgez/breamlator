package es.pablordgz.breamlator.services.translation;

import es.pablordgz.breamlator.repositories.AI.AIRepository;
import es.pablordgz.breamlator.utils.AITranslationContextBuilder;
import org.springframework.beans.factory.annotation.Qualifier;

public class AITranslationService implements TranslationService {

    private final AIRepository aiRepo;

    public AITranslationService(AIRepository aiRepo) {
        this.aiRepo = aiRepo;
    }

    @Override
    public String translate(String text, String language) {
        if (!aiRepo.isAvailable()) {
            return "The message could not be retrieved";
        }
        return aiRepo.getMessage(text, AITranslationContextBuilder.getContext(language));
    }
}
