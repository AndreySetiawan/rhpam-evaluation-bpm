package jbpm.evaluation;

import java.util.List;

import org.kie.server.api.model.instance.TaskSummary;
import org.kie.server.client.KieServicesClient;
import org.kie.server.client.KieServicesConfiguration;
import org.kie.server.client.KieServicesFactory;
import org.kie.server.client.UserTaskServicesClient;

public class EvaluationGetTaskList {

    private Credentials user = new Credentials();

    private List<TaskSummary> taskList;

    public void get(String name, String login) throws Exception {

        user.login(login);

        KieServicesConfiguration config = KieServicesFactory.newRestConfiguration(
                user.getServerUrl(), user.getUsername(), user.getPassword());
        KieServicesClient client = KieServicesFactory.newKieServicesClient(config);
        UserTaskServicesClient taskServices = client.getServicesClient(UserTaskServicesClient.class);

        taskList = taskServices.findTasksAssignedAsPotentialOwner(name, 0, 10);
    }

    public List<TaskSummary> getTaskList () {
        return this.taskList;
    }
}
