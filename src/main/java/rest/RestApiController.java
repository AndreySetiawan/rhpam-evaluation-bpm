package rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("evaluation")
public class RestApiController {

    // localhost:8080/swagger-ui.html

    @RequestMapping(method = RequestMethod.GET, produces = "application/json", path = "getTaskList")
    public EvalGetTaskList getTaskList (@RequestParam String name, @RequestParam String login) {
        return new EvalGetTaskList(name, login);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json", path = "startInstance")
    public EvalStartInstance startInstance (@RequestParam String employee, @RequestParam String reason) {
        return new EvalStartInstance(employee, reason);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json", path = "selfEvaluation")
    public EvaSelfEvaluation selfEvaluation (@RequestParam Long taskId, @RequestParam int perfomance, @RequestParam String login) {
        return new EvaSelfEvaluation(taskId, perfomance, login);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json", path = "hrEvaluation")
    public EvaHrEvaluation hrEvaluation (@RequestParam Long taskId, @RequestParam int perfomance, @RequestParam String login) {
        return new EvaHrEvaluation(taskId, perfomance, login);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json", path = "pmEvaluation")
    public EvaPmEvaluation pmEvaluation (@RequestParam Long taskId, @RequestParam int perfomance, @RequestParam String login) {
        return new EvaPmEvaluation(taskId, perfomance, login);
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json", path = "getInstanceLogs")
    public EvalGetInstanceLogs getInstanceLogs (@RequestParam Long instanceId, @RequestParam String login) {
        return new EvalGetInstanceLogs(instanceId, login);
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json", path = "getInstanceByVariable")
    public EvaGetInstanceByVariable getInstanceByVariable (@RequestParam String varName, @RequestParam String varValue, @RequestParam Integer status, @RequestParam String login) {
        return new EvaGetInstanceByVariable(varName, varValue, status, login);
    }
}