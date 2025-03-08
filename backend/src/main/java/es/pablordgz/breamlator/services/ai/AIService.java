package es.pablordgz.breamlator.services.ai;

import es.pablordgz.breamlator.repositories.AI.registries.AIRepositoryRegistry;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AIService {
    private final AIRepositoryRegistry registry;

    public AIService(@Qualifier("AIRepositoryRegistryImpl") AIRepositoryRegistry registry) {
        this.registry = registry;
    }

    public List<String> listRepositories() {
        return registry.getAllAINames();
    }
}
