package rest;

import jbpm.evaluation.EvaluationSelfEvaluation;

public class EvaSelfEvaluation {

    private String message;

    public EvaSelfEvaluation(Long taskId, int perfomance, String login) {
        EvaluationSelfEvaluation myService = new EvaluationSelfEvaluation();

        message = "Done";

        try {
            myService.selfEvaluation(taskId, perfomance, login);

        } catch (Exception e) {
            message = "Error!";
        }
    }

    public String getMessage () {
        return this.message;
    }
}
