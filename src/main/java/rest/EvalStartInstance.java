package rest;

import jbpm.evaluation.EvaluationStartInstance;

public class EvalStartInstance {

    private Long newInstanceId;

    private String message;

    public EvalStartInstance (String employee, String reason){
        EvaluationStartInstance myService = new EvaluationStartInstance();

        try {
            myService.start(employee, reason);

            newInstanceId = myService.getNewInstannceId();

            message = "New Instance with ID: " + this.newInstanceId;
        } catch (Exception e) {
            message = "Error!";
        }
    }

    public String getMessage () {
        return this.message;
    }
}
