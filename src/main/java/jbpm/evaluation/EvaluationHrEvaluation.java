package jbpm.evaluation;

import org.kie.server.api.model.instance.TaskSummary;
import org.kie.server.client.KieServicesClient;
import org.kie.server.client.KieServicesConfiguration;
import org.kie.server.client.KieServicesFactory;
import org.kie.server.client.UserTaskServicesClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluationHrEvaluation {

    private Credentials user = new Credentials();

    public void hrEvaluation(Long taskId, int perfomance, String login) throws Exception {

        user.login(login);
        
        KieServicesConfiguration config = KieServicesFactory.newRestConfiguration(
                user.getServerUrl(), user.getUsername(), user.getPassword());
        KieServicesClient client = KieServicesFactory.newKieServicesClient(config);
        UserTaskServicesClient taskServices = client.getServicesClient(UserTaskServicesClient.class);

        List<TaskSummary> tasks = taskServices.findTasksAssignedAsPotentialOwner(user.getUsername(), 0, 10);
        TaskSummary task = findTask(tasks, taskId);

        System.out.println("bogo completing task " + task.getName() + ": " + task.getDescription());
        taskServices.claimTask("evaluation_1.0.0-SNAPSHOT", task.getId(), user.getUsername());
        taskServices.startTask("evaluation_1.0.0-SNAPSHOT", task.getId(), user.getUsername());
        Map<String, Object> results = new HashMap<String, Object>();
        results.put("performance", perfomance);
        taskServices.completeTask("evaluation_1.0.0-SNAPSHOT", task.getId(), user.getUsername(), results);
    }

    private TaskSummary findTask(List<TaskSummary> tasks, long taskId) {
        for (TaskSummary task: tasks) {
            if (task.getId() == taskId && task.getName().equals("HR Evaluation")) {
                return task;
            }
        }
        throw new RuntimeException("Could not find task for process instance "
                + taskId + " [" + tasks.size() + " task(s) in total]");
    }
}
