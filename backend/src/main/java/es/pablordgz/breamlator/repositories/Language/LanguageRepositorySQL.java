package es.pablordgz.breamlator.repositories.Language;

import es.pablordgz.breamlator.entities.Language;
import org.springframework.data.repository.CrudRepository;

public interface LanguageRepositorySQL extends LanguageRepository, CrudRepository<Language, Long> {

}
