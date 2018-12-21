package rest;

import jbpm.evaluation.EvaluationGetInstanceLogs;
import org.kie.server.api.model.instance.NodeInstance;

import java.util.List;

public class EvalGetInstanceLogs {

    private List<NodeInstance> nodeList;

    private String message = "";

    public EvalGetInstanceLogs(Long instanceId, String login) {
        EvaluationGetInstanceLogs myService = new EvaluationGetInstanceLogs();

        try {
            myService.get(instanceId, login);
        } catch (Exception e) {
            e.printStackTrace();
        }

        nodeList = myService.getNodeList();

        System.out.println(message);
    }

    public List<NodeInstance> getNodeList() {
        return this.nodeList;
    }
}
