package es.pablordgz.breamlator.repositories.AI;

import org.springframework.stereotype.Repository;

@Repository
public interface AIRepository {
    String getMessage(String prompt, String context);

    String getMessage(String prompt, String context, String apiKey);

    String getMessage(String prompt, String context, String apiKey, String model);

    boolean isAvailable();

    String getName();

}
