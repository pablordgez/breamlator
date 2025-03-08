package es.pablordgz.breamlator.services.translation;

import org.springframework.stereotype.Service;

@Service
public interface TranslationService {
    /**
     * @param text     The text to translate
     * @param language A description of the language, necessary for translation methods that use AI. For non AI translations its value is irrelevant
     * @return The translated message
     */
    String translate(String text, String language);
}
