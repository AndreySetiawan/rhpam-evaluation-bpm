package jbpm.evaluation;

import java.util.HashMap;
import java.util.Map;

import org.kie.server.client.KieServicesClient;
import org.kie.server.client.KieServicesConfiguration;
import org.kie.server.client.KieServicesFactory;
import org.kie.server.client.ProcessServicesClient;

public class EvaluationStartInstance {

    private Credentials user = new Credentials();

    private Long newInstanceId;

    public void start(String employee, String reason) throws Exception {

        KieServicesConfiguration config = KieServicesFactory.newRestConfiguration(
                user.getServerUrl(), "bogo", "atiila");
        KieServicesClient client = KieServicesFactory.newKieServicesClient(config);
        ProcessServicesClient processServices = client.getServicesClient(ProcessServicesClient.class);

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("employee", employee);
        params.put("reason", reason);

        newInstanceId = processServices.startProcess("evaluation_1.0.0-SNAPSHOT", "evaluation", params);
    }

    public Long getNewInstannceId () {
        return this.newInstanceId;
    }
}
