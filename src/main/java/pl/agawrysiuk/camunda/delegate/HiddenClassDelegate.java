package pl.agawrysiuk.camunda.delegate;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

@Slf4j
public class HiddenClassDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        log.info("LOG [{}]: Invoking Java class, and NOT a Bean.", execution.getProcessInstanceId());
    }
}
