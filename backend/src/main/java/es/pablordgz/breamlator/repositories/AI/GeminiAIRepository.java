package es.pablordgz.breamlator.repositories.AI;

import es.pablordgz.breamlator.utils.HTTPRequester;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class GeminiAIRepository extends AbstractAIRepository {

    private final String baseURL = "https://generativelanguage.googleapis.com/v1beta/models/";
    private String model = "gemini-2.0-flash";

    public GeminiAIRepository() {
        super("GEMINI");
    }

    @Override
    public String getMessage(String prompt, String context) {
        Map<String, Object> params = formatPrompt(prompt, formatContext(context));
        JSONArray response = HTTPRequester.request(baseURL + model + ":generateContent" + "?key=" + getAPIKey(), HTTPRequester.Method.POST, params);
        return response.getJSONObject(0).getJSONArray("candidates").getJSONObject(0).getJSONObject("content").getJSONArray("parts").getJSONObject(0).getString("text");
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

    public void setModel(String model) {
        this.model = model;
    }

}
