package es.pablordgz.breamlator.repositories.AI;

public interface AIRepository {
    String getMessage(String prompt, String context);

    boolean isAvailable();
}
