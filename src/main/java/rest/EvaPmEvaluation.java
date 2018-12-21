package rest;


import jbpm.evaluation.EvaluationPmEvaluation;

public class EvaPmEvaluation {

    private String message;

    public EvaPmEvaluation(Long taskId, int perfomance, String login) {
        EvaluationPmEvaluation myService = new EvaluationPmEvaluation();

        message = "Done!";

        try {
            myService.pmEvaluation(taskId, perfomance, login);
        } catch (Exception e) {
            message = "Error!";
        }
    }

    public String getMessage () {
        return this.message;
    }
}
