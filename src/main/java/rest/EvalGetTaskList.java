package rest;

import jbpm.evaluation.EvaluationGetTaskList;
import org.kie.server.api.model.instance.TaskSummary;

import java.util.List;

public class EvalGetTaskList {

    private List<TaskSummary> taskList;

    private String message = "";

    public EvalGetTaskList(String name, String login) {
        EvaluationGetTaskList myService = new EvaluationGetTaskList();

        try {
            myService.get(name, login);
        } catch (Exception e) {
            e.printStackTrace();
        }

        taskList = myService.getTaskList();

        System.out.println(message);
    }

    public List<TaskSummary> getTaskList () {
        return this.taskList;
    }
}
