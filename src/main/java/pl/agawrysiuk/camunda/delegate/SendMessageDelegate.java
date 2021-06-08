package pl.agawrysiuk.camunda.delegate;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

@Slf4j
public class SendMessageDelegate implements JavaDelegate {

    private static final String MESSAGE_NAME = "MESSAGE_NAME";

    @Override
    public void execute(DelegateExecution execution) {
        String messageName = (String) execution.getVariable(MESSAGE_NAME);
        try {
            execution.getProcessEngineServices()
                    .getRuntimeService()
                    .createMessageCorrelation(messageName)
                    .processInstanceId(execution.getProcessInstanceId())
                    .correlate();
        } catch (Exception ex) {
            log.info("LOG [{}]: Cannot correlate message {}", execution.getProcessInstanceId(), messageName);
        }
    }
}
