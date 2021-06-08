package pl.agawrysiuk.camunda.delegate;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.ArrayList;

import static pl.agawrysiuk.camunda.utils.VariableNames.EXTRAS;
import static pl.agawrysiuk.camunda.utils.VariableNames.EXTRAS_DOWNLOADED;
import static pl.agawrysiuk.camunda.utils.VariableNames.PIZZA_AVAILABLE;
import static pl.agawrysiuk.camunda.utils.VariableNames.SHOP_ID;

@Slf4j
public class CheckShopOpenDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        log.info("LOG [{}]: CheckShopOpenDelegate executing...", execution.getProcessInstanceId());

        try {
            int shopId = (int) execution.getVariable(SHOP_ID);
            if(shopId <= 0) throw new Exception();
        } catch (Exception e) {
            log.info("LOG [{}]: Shop closed or not existing. Throwing error.", execution.getProcessInstanceId());
            throw new BpmnError("ShopClosedOrNotExistingError");
        }

        log.info("LOG [{}]: Shop open. Setting initial data and moving on.", execution.getProcessInstanceId());

        execution.setVariable(EXTRAS_DOWNLOADED, false);
        execution.setVariable(PIZZA_AVAILABLE, false);
        execution.setVariable(EXTRAS, new ArrayList());

    }
}
