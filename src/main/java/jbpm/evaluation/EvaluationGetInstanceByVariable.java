package jbpm.evaluation;

import org.kie.server.api.model.instance.ProcessInstance;
import org.kie.server.client.KieServicesClient;
import org.kie.server.client.KieServicesConfiguration;
import org.kie.server.client.KieServicesFactory;
import org.kie.server.client.QueryServicesClient;

import java.util.Collections;
import java.util.List;

public class EvaluationGetInstanceByVariable {

    private List<ProcessInstance> instanceList;

    private Credentials user = new Credentials();

    public void get(String varName, String varValue, Integer status, String login) throws Exception{

        user.login(login);

        KieServicesConfiguration config = KieServicesFactory.newRestConfiguration(
                user.getServerUrl(), user.getUsername(), user.getPassword());
        KieServicesClient client = KieServicesFactory.newKieServicesClient(config);
        QueryServicesClient queryServices = client.getServicesClient(QueryServicesClient.class);

        instanceList = queryServices.findProcessInstancesByVariableAndValue(varName, varValue, Collections.singletonList(status), 0, 10);
    }

    public List<ProcessInstance> getIntanceList(){
        return this.instanceList;
    }
}
