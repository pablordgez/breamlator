package es.pablordgz.breamlator.repositories.AI.registries;

import es.pablordgz.breamlator.repositories.AI.AIRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AIRepositoryRegistry {
    AIRepository getAIRepository(String name);

    List<String> getAllAINames();
}
