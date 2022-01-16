package fr.esgi.tp1605.use_cases.user.application;

import fr.esgi.tp1605.kernel.Event;
import fr.esgi.tp1605.kernel.EventDispatcher;
import fr.esgi.tp1605.use_cases.user.domain.UserId;
import fr.esgi.tp1605.use_cases.user.domain.UserRepository;

public class UserService {

    private UserRepository userRepository;
    private EventDispatcher<Event> eventDispatcher;

    public UserService(UserRepository userRepository, EventDispatcher<Event> eventDispatcher) {
        this.userRepository = userRepository;
        this.eventDispatcher = eventDispatcher;
    }

    public void modifyUserMembership(ModifyUserMembership command){
        var userId = new UserId(command.userId);
        var user = userRepository.findById(userId);
        var membership = command.membership;
        user.setMembership(membership);
        userRepository.add(user);
        eventDispatcher.dispatch(new ModifyUserMembershipEvent(userId));
    }
}
