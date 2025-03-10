package es.pablordgz.breamlator.repositories.AI;

import es.pablordgz.breamlator.utils.HTTPRequester;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository("geminiAIRepository")
public class GeminiAIRepository extends AbstractAIRepository {

    private final String baseURL = "https://generativelanguage.googleapis.com/v1beta/models/";
    private final String model = "gemini-2.0-flash";

    public GeminiAIRepository() {
        super("GEMINI");
    }

    @Override
    public String getMessage(String prompt, String context) {
        return getMessage(prompt, context, getAPIKey());
    }

    @Override
    public String getMessage(String prompt, String context, String apiKey) {
        return getMessage(prompt, context, apiKey, model);
    }

    @Override
    public String getMessage(String prompt, String context, String apiKey, String model) {
        Map<String, Object> params = formatPrompt(prompt, formatContext(context));
        JSONArray response = HTTPRequester.request(baseURL + model + ":generateContent" + "?key=" + apiKey, HTTPRequester.Method.POST, params);
        if (response.getJSONObject(0).has("success") && response.getJSONObject(0).getString("success").equals("false")) {
            return "The message could not be retrieved";
        }
        try {
            return response.getJSONObject(0).getJSONArray("candidates").getJSONObject(0).getJSONObject("content").getJSONArray("parts").getJSONObject(0).getString("text");
        } catch (Exception e) {
            return "The message could not be retrieved";
        }
    }

    private Map<String, Object> formatContext(String context) {
        Map<String, Object> params = new HashMap<String, Object>();
        JSONObject systemInstructions = new JSONObject();
        JSONObject systemInstructionParts = new JSONObject();
        systemInstructionParts.put("text", context);
        systemInstructions.put("parts", systemInstructionParts);
        params.put("system_instruction", systemInstructions);
        return params;
    }

    private Map<String, Object> formatPrompt(String prompt, Map<String, Object> context) {
        JSONObject contents = new JSONObject();
        JSONObject contentsParts = new JSONObject();
        contentsParts.put("text", prompt);
        contents.put("parts", contentsParts);
        context.put("contents", contents);
        return context;
    }

}
