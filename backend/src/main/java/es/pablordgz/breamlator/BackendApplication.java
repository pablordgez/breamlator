package es.pablordgz.breamlator;

import es.pablordgz.breamlator.repositories.AI.GeminiAIRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class BackendApplication {
    public static void main(String[] args) throws IOException {
        GeminiAIRepository geminiAIRepository = new GeminiAIRepository();
        SpringApplication.run(BackendApplication.class, args);
    }

}
