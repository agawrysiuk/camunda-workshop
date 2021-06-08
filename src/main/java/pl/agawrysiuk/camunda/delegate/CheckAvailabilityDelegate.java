package pl.agawrysiuk.camunda.delegate;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import static pl.agawrysiuk.camunda.utils.VariableNames.PIZZA_AVAILABLE;
import static pl.agawrysiuk.camunda.utils.VariableNames.PIZZA_NAME;
import static pl.agawrysiuk.camunda.utils.VariableNames.PRICE;

@Slf4j
public class CheckAvailabilityDelegate implements JavaDelegate {

    public static final String PIZZA_NAMES_NOT_SERVED = "h";

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        log.info("LOG [{}]: CheckAvailabilityDelegate executing...", execution.getProcessInstanceId());

        String pizzaName = (String) execution.getVariable(PIZZA_NAME);
        if(pizzaName != null && !pizzaName.toLowerCase().startsWith(PIZZA_NAMES_NOT_SERVED)) {
            execution.setVariable(PIZZA_AVAILABLE, true);
            execution.setVariable(PRICE, 10);
        }
    }
}
