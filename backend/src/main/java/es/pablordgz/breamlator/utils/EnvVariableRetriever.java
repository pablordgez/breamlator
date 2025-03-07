package es.pablordgz.breamlator.utils;

import io.github.cdimascio.dotenv.Dotenv;

public class EnvVariableRetriever {
    private final static Dotenv dotenv = Dotenv.load();

    public final static String NOT_FOUND = "not-found";

    public static String getVariable(String key) {
        return dotenv.get(key, NOT_FOUND);
    }
}
