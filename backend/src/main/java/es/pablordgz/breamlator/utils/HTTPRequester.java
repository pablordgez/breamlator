package es.pablordgz.breamlator.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HTTPRequester {
    public enum Method {
        GET,
        POST
    }


    public static Map<String, String> request(String url, Method method, Map<String, String> body) throws IOException {
        // TODO
        return new HashMap<>();
    }


}
