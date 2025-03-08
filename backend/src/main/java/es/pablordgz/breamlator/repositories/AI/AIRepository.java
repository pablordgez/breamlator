package es.pablordgz.breamlator.repositories.AI;

import org.springframework.stereotype.Repository;

@Repository
public interface AIRepository {
    String getMessage(String prompt, String context);

    boolean isAvailable();

}
