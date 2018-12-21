package jbpm.evaluation;

import org.kie.server.api.model.instance.NodeInstance;
import org.kie.server.client.KieServicesClient;
import org.kie.server.client.KieServicesConfiguration;
import org.kie.server.client.KieServicesFactory;
import org.kie.server.client.ProcessServicesClient;

import java.util.List;

public class EvaluationGetInstanceLogs {

    private Credentials user = new Credentials();

    private List<NodeInstance> nodeList;

    public void get(Long instanceId, String login) throws Exception {

        user.login(login);

        KieServicesConfiguration config = KieServicesFactory.newRestConfiguration(
                user.getServerUrl(), user.getUsername(), user.getPassword());
        KieServicesClient client = KieServicesFactory.newKieServicesClient(config);
        ProcessServicesClient processServices = client.getServicesClient(ProcessServicesClient.class);

        nodeList = processServices.findNodeInstances("evaluation_1.0.0-SNAPSHOT", instanceId, 0 ,10);
    }

    public List<NodeInstance> getNodeList() {
        return this.nodeList;
    }
}
