package es.pablordgz.breamlator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class BackendApplication {
    public static void main(String[] args) throws IOException {
        SpringApplication.run(BackendApplication.class, args);
    }

}
