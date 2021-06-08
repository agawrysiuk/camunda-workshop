package pl.agawrysiuk.camunda.delegate;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import static pl.agawrysiuk.camunda.utils.VariableNames.UNIVERSAL_MESSAGE;

@Slf4j
public class UniversalDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        String message = (String) execution.getVariable(UNIVERSAL_MESSAGE);
        log.info("LOG [{}]: {}", execution.getProcessInstanceId(), message);
    }
}
