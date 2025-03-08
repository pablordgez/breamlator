package es.pablordgz.breamlator.repositories.Language;

import es.pablordgz.breamlator.entities.Language;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LanguageRepository {
    List<Language> findAll();

    Language findByName(String name);
}
