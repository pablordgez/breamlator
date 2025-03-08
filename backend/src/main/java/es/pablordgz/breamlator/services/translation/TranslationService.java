package es.pablordgz.breamlator.services.translation;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface TranslationService {
    /**
     * @param text        The text to translate
     * @param language    A description of the language, necessary for translation methods that use AI. For non AI translations its value is irrelevant
     * @param extraParams Extra parameters that might be needed by different implementations, for example api keys
     * @return The translated message
     */
    String translate(String text, String language, Map<String, String> extraParams);
}
