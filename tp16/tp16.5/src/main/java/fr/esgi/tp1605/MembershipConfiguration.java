/*package fr.esgi.tp1605;

import fr.esgi.tp1605.kernel.Event;
import fr.esgi.tp1605.kernel.EventDispatcher;
import fr.esgi.tp1605.kernel.EventListener;
import fr.esgi.tp1605.use_cases.user.application.*;
import fr.esgi.tp1605.use_cases.user.domain.MembershipRepository;
import fr.esgi.tp1605.use_cases.user.infrastructure.DefaultEventDispatcher;
import fr.esgi.tp1605.use_cases.user.infrastructure.InMemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class MembershipConfiguration {

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
}
*/