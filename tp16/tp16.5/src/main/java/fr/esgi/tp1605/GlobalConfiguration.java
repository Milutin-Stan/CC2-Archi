package fr.esgi.tp1605;


import fr.esgi.tp1605.kernel.*;
import fr.esgi.tp1605.use_cases.payment.application.*;
import fr.esgi.tp1605.use_cases.payment.domain.PaymentRepository;
import fr.esgi.tp1605.use_cases.payment.infrastructure.InMemoryPaymentRepository;
import fr.esgi.tp1605.use_cases.user.application.*;
import fr.esgi.tp1605.use_cases.user.domain.MembershipRepository;
import fr.esgi.tp1605.use_cases.user.domain.UserRepository;
import fr.esgi.tp1605.use_cases.user.infrastructure.DefaultEventDispatcher;
import fr.esgi.tp1605.use_cases.user.infrastructure.InMemoryMemberRepository;
import fr.esgi.tp1605.use_cases.user.infrastructure.InMemoryUserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class GlobalConfiguration {

    @Bean
    public UserRepository userRepository() {
        return new InMemoryUserRepository();
    }

    @Bean
    public EventDispatcher<Event> eventEventDispatcher() {
        final Map<Class<? extends Event>, List<EventListener<? extends Event>>> listenerMap = new HashMap<>();
        listenerMap.put(ModifyUserAddressEvent.class, List.of(new ModifyUserAddressEventListener()));
        listenerMap.put(CreateUserEvent.class, List.of(new CreateUserEventListener()));
        listenerMap.put(ModifyUserMembershipEvent.class, List.of(new ModifyUserMembershipEventListener()));
        return new DefaultEventDispatcher(listenerMap);
    }

    @Bean
    public CreateUserCommandHandler createUserCommandHandler() {
        return new CreateUserCommandHandler(userRepository(), eventEventDispatcher());
    }

    @Bean
    public ModifyUserAddressCommandHandler modifyUserAddressCommandHandler() {
        return new ModifyUserAddressCommandHandler(userRepository(), eventEventDispatcher());
    }

    @Bean
    public ModifyUserMembershipCommandHandler modifyUserMembershipCommandHandler(){
        return new ModifyUserMembershipCommandHandler(userRepository(),eventEventDispatcher());
    }


    @Bean
    public RetrieveUsersHandler retrieveUsersHandler() {
        return new RetrieveUsersHandler(userRepository());
    }

    @Bean
    public RetrieveUsersByCityHandler retrieveUsersByCityHandler() {
        return new RetrieveUsersByCityHandler(userRepository());
    }

    @Bean
    public MembershipRepository membershipRepository(){
        return new InMemoryMemberRepository();
    }

    @Bean
    public EventDispatcher<Event> membershipEventDispatcher() {
        final Map<Class<? extends Event>, List<EventListener<? extends Event>>> listenerMap = new HashMap<>();
        listenerMap.put(CreateMembershipEvent.class, List.of(new CreateMembershipEventListener()));
        return new DefaultEventDispatcher(listenerMap);
    }

    @Bean
    public CreateMembershipCommandHandler createMembershipCommandHandler(){
        return new CreateMembershipCommandHandler(membershipRepository(),membershipEventDispatcher());
    }
    @Bean
    public PaymentRepository paymentRepository(){
        return new InMemoryPaymentRepository();
    }

    @Bean
    public EventDispatcher<Event> paymentEventDispatcher() {
        final Map<Class<? extends Event>, List<EventListener<? extends Event>>> listenerMap = new HashMap<>();
        listenerMap.put(CreatePaymentEvent.class, List.of(new CreatePaymentEventListener(modifyUserMembershipCommandHandler())));
        //listenerMap.put(ApplyForNewMembershipEvent.class, List.of(new ApplyForNewMembershipEventListener(userService())));
        return new DefaultEventDispatcher(listenerMap);
    }

    @Bean
    public CreatePaymentCommandHandler createPaymentCommandHandler(){
        return new CreatePaymentCommandHandler(paymentRepository(), paymentEventDispatcher());
    }

    @Bean
    public RetrievePaymentsHandler retrievePaymentsHandler(){
        return new RetrievePaymentsHandler(paymentRepository());
    }

    @Bean
    public RetrieveMembershipsHandler retrieveMembershipsHandler(){
        return new RetrieveMembershipsHandler(membershipRepository());
    }


    @Bean
    public CommandBus commandBus() {
        final Map<Class<? extends Command>, CommandHandler> commandHandlerMap = new HashMap<>();
        commandHandlerMap.put(CreatePayment.class, createPaymentCommandHandler());
        commandHandlerMap.put(ModifyUserMembership.class, modifyUserMembershipCommandHandler());
        return new SimpleCommandBus(commandHandlerMap);
    }
}
