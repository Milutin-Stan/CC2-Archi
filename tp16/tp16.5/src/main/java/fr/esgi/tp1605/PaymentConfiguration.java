/*package fr.esgi.tp1605;

import fr.esgi.tp1605.kernel.*;
import fr.esgi.tp1605.use_cases.payment.application.*;
import fr.esgi.tp1605.use_cases.payment.domain.PaymentRepository;
import fr.esgi.tp1605.use_cases.payment.infrastructure.InMemoryPaymentRepository;
import fr.esgi.tp1605.use_cases.user.infrastructure.DefaultEventDispatcher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
    public PaymentService paymentService(){
        return new PaymentService(paymentRepository(), paymentEventDispatcher());
    }

    @Bean
    public EventDispatcher<Event> paymentEventDispatcher() {
        final Map<Class<? extends Event>, List<EventListener<? extends Event>>> listenerMap = new HashMap<>();
        listenerMap.put(CreatePaymentEvent.class, List.of(new CreatePaymentEventListener()));
        listenerMap.put(ApplyForNewMembershipEvent.class, List.of(new ApplyForNewMembershipEventListener()));
        return new DefaultEventDispatcher(listenerMap);
    }

    @Bean
    public CreatePaymentCommandHandler createPaymentCommandHandler(){
        return new CreatePaymentCommandHandler(paymentRepository(),paymentEventDispatcher(), paymentService());
    }

    @Bean
    public ApplyForNewMembershipCommandHandler applyForNewMembershipCommandHandler(){
        return new ApplyForNewMembershipCommandHandler(paymentRepository(),paymentEventDispatcher(), paymentService());
    }

    @Bean
    public CommandBus commandBus() {
        final Map<Class<? extends Command>, CommandHandler> commandHandlerMap = new HashMap<>();
        commandHandlerMap.put(ApplyForNewMembership.class, new ApplyForNewMembershipCommandHandler(paymentRepository(), paymentEventDispatcher(), paymentService()));
        commandHandlerMap.put(CreatePayment.class, new CreatePaymentCommandHandler(paymentRepository(),paymentEventDispatcher(),paymentService()));
        return new SimpleCommandBus(commandHandlerMap);
    }
}
*/