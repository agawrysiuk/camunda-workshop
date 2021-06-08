package pl.agawrysiuk.camunda.listeners;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;

@Slf4j
public class LogListener implements ExecutionListener {

    @Override
    public void notify(DelegateExecution delegateExecution) throws Exception {
        String elementId = delegateExecution.getBpmnModelElementInstance().getId();
        log.info("LOG [{}]: {} processed", delegateExecution.getProcessInstanceId(), elementId);
    }
}
