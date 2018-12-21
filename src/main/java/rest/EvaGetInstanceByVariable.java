package rest;

import jbpm.evaluation.EvaluationGetInstanceByVariable;
import org.kie.server.api.model.instance.ProcessInstance;

import java.util.List;

public class EvaGetInstanceByVariable {

    private List<ProcessInstance> instanceList;

    public EvaGetInstanceByVariable(String varName, String varValue, Integer status, String login) {
        EvaluationGetInstanceByVariable myService = new EvaluationGetInstanceByVariable();

        try {
            myService.get(varName, varValue, status, login);
        } catch (Exception e) {
            e.printStackTrace();
        }

        instanceList= myService.getIntanceList();
    }

    public List<ProcessInstance> getResponse() {
        return this.instanceList;
    }
}
