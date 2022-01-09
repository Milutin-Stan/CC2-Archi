package fr.esgi.tp1605;

import fr.esgi.tp1605.kernel.ApplicationEvent;
import fr.esgi.tp1605.kernel.Event;
import fr.esgi.tp1605.kernel.EventDispatcher;
import fr.esgi.tp1605.kernel.EventListener;
import fr.esgi.tp1605.use_cases.payment.application.*;
import fr.esgi.tp1605.use_cases.payment.domain.PaymentRepository;
import fr.esgi.tp1605.use_cases.payment.infrastructure.InMemoryPaymentRepository;
import fr.esgi.tp1605.use_cases.user.infrastructure.DefaultEventDispatcher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import fr.esgi.tp1605.UserConfiguration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class PaymentConfiguration {

    private UserConfiguration userConfiguration;

    @Bean
    public PaymentRepository paymentRepository(){
        return new InMemoryPaymentRepository();
    }

    @Bean
    public EventDispatcher<Event> paymentEventDispatcher() {
        final Map<Class<? extends Event>, List<EventListener<? extends Event>>> listenerMap = new HashMap<>();
        listenerMap.put(CreatePaymentEvent.class, List.of(new CreatePaymentEventListener()));
        listenerMap.put(ApplicationEvent.class, List.of(new ApplyForNewMembershipEventListener()));
        return new DefaultEventDispatcher(listenerMap);
    }

    @Bean
    public CreatePaymentCommandHandler createPaymentCommandHandler(){
        return new CreatePaymentCommandHandler(paymentRepository(),paymentEventDispatcher());
    }

    @Bean
    public ApplyForNewMembershipCommandHandler applyForNewMembershipCommandHandler(){
        return new ApplyForNewMembershipCommandHandler(paymentRepository(),paymentEventDispatcher());
    }
}
