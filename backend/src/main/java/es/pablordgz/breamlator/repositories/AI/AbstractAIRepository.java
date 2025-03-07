package es.pablordgz.breamlator.repositories.AI;

import es.pablordgz.breamlator.utils.EnvVariableRetriever;

public abstract class AbstractAIRepository implements AIRepository {
    private final String AIName;

    public AbstractAIRepository(String AIName) {
        this.AIName = AIName;
    }

    @Override
    public boolean isAvailable() {
        return !EnvVariableRetriever.getVariable(AIName + "_API_KEY").equals(EnvVariableRetriever.NOT_FOUND);
    }
    
    protected String getAPIKey() {
        return EnvVariableRetriever.getVariable(AIName + "_API_KEY");
    }


}
