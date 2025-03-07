package es.pablordgz.breamlator.utils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class HTTPRequester {
    public enum Method {
        GET,
        POST

    }


    public static JSONArray request(String url, Method method, Map<String, String> body) throws IOException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = null;
        if (method == Method.GET) {
            String completeURL = buildGetURL(url, body);
            request = HttpRequest.newBuilder().uri(URI.create(completeURL)).GET().build();

        } else if (method == Method.POST) {
            request = HttpRequest.newBuilder().uri(URI.create(url)).header("Content-Type", "application/json").POST(HttpRequest.BodyPublishers.ofString(buildPostBody(body))).build();
        }
        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (InterruptedException e) {
            HashMap<String, String> result = new HashMap<>();
            JSONArray array = new JSONArray();
            result.put("success", "false");
            array.put(result);
            return array;
        }
        return buildResponseBody(response.body());
    }

    private static String buildPostBody(Map<String, String> body) {
        JSONObject obj = new JSONObject(body);
        return obj.toString();

    }

    private static String buildGetURL(String url, Map<String, String> params) {
        StringBuilder sb = new StringBuilder();
        sb.append(url);
        for (Map.Entry<String, String> entry : params.entrySet()) {
            sb.append(URLEncoder.encode(entry.getKey()));
            sb.append("=");
            sb.append(URLEncoder.encode(entry.getValue()));
            sb.append("&");
        }
        if (sb.charAt(sb.length() - 1) == '&') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    private static JSONArray buildResponseBody(String body) {
        JSONArray array = new JSONArray();
        if (body.startsWith("{")) {
            JSONObject obj = new JSONObject(body);
            array.put(obj);
        } else if (body.startsWith("[")) {
            array = new JSONArray(body);
        }
        return array;

    }


}
