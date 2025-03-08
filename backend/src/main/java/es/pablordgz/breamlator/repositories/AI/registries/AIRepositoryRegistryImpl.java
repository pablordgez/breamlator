package es.pablordgz.breamlator.repositories.AI.registries;

import es.pablordgz.breamlator.repositories.AI.AIRepository;
import es.pablordgz.breamlator.repositories.AI.GeminiAIRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class AIRepositoryRegistryImpl implements AIRepositoryRegistry {

    private final Map<String, AIRepository> repositories = new HashMap<>();

    public AIRepositoryRegistryImpl() {
        repositories.put("GEMINI", new GeminiAIRepository());
    }

    @Override
    public AIRepository getAIRepository(String name) {
        if (repositories.containsKey(name)) {
            return repositories.get(name);
        }
        return null;
    }
}
