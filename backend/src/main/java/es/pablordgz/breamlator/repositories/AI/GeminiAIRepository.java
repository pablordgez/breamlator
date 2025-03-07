package es.pablordgz.breamlator.repositories.AI;

public class GeminiAIRepository extends AbstractAIRepository {

    private String model = "gemini-2.0-flash";

    public GeminiAIRepository() {
        super("GEMINI");
    }

    @Override
    public String getMessage(String prompt, String context) {
        // TODO
        return "";
    }

    public void setModel(String model) {
        this.model = model;
    }

}
