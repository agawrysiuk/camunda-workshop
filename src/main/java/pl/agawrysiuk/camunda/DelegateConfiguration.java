package pl.agawrysiuk.camunda;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.agawrysiuk.camunda.delegate.CheckAvailabilityDelegate;
import pl.agawrysiuk.camunda.delegate.CheckShopOpenDelegate;
import pl.agawrysiuk.camunda.delegate.SendMessageDelegate;
import pl.agawrysiuk.camunda.delegate.UniversalDelegate;
import pl.agawrysiuk.camunda.listeners.LogListener;

@Configuration
public class DelegateConfiguration {

    @Bean
    public LogListener logListener() {
        return new LogListener();
    }

    @Bean
    public CheckShopOpenDelegate checkShopOpenDelegate() {
        return new CheckShopOpenDelegate();
    }

    @Bean
    public CheckAvailabilityDelegate checkAvailabilityDelegate() {
        return new CheckAvailabilityDelegate();
    }

    @Bean
    public UniversalDelegate universalDelegate() {
        return new UniversalDelegate();
    }

    @Bean
    public SendMessageDelegate sendMessageDelegate() {
        return new SendMessageDelegate();
    }
}
