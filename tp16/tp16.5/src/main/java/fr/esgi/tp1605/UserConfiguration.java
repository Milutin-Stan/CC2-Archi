/*package fr.esgi.tp1605;

import fr.esgi.tp1605.kernel.*;
import fr.esgi.tp1605.use_cases.user.application.*;
import fr.esgi.tp1605.use_cases.user.domain.UserRepository;
import fr.esgi.tp1605.use_cases.user.infrastructure.DefaultEventDispatcher;
import fr.esgi.tp1605.use_cases.user.infrastructure.InMemoryUserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class UserConfiguration {

    @Bean
    public UserRepository userRepository() {
        return new InMemoryUserRepository();
    }

    @Bean
    public UserService userService(){
        return new UserService(userRepository(),eventEventDispatcher());
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
        return new ModifyUserMembershipCommandHandler(userService());
    }


    @Bean
    public RetrieveUsersHandler retrieveUsersHandler() {
        return new RetrieveUsersHandler(userRepository());
    }

    @Bean
    public RetrieveUsersByCityHandler retrieveUsersByCityHandler() {
        return new RetrieveUsersByCityHandler(userRepository());
    }

   /* @Bean
    public CommandBus userCommandBus() {
        final Map<Class<? extends Command>, CommandHandler> commandHandlerMap = new HashMap<>();
        commandHandlerMap.put(ModifyUserMembership.class, new ModifyUserAddressCommandHandler(userRepository(), eventEventDispatcher()));
        return new SimpleCommandBus(commandHandlerMap);
    }
}
*/