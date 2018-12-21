package rest;

import jbpm.evaluation.EvaluationHrEvaluation;

public class EvaHrEvaluation {

    private String message;

    public EvaHrEvaluation(Long taskId, int perfomance, String login) {
        EvaluationHrEvaluation myService = new EvaluationHrEvaluation();

        message = "Done!";

        try {
            myService.hrEvaluation(taskId, perfomance, login);
        } catch (Exception e) {
            message = "Error!";
        }
    }

    public String getMessage () {
        return this.message;
    }
}
