package fr.esgi.tp1605.use_cases.user.application;

import fr.esgi.tp1605.kernel.CommandHandler;
import fr.esgi.tp1605.kernel.Event;
import fr.esgi.tp1605.kernel.EventDispatcher;
import fr.esgi.tp1605.use_cases.user.domain.UserId;
import fr.esgi.tp1605.use_cases.user.domain.UserRepository;

public class ModifyUserMembershipCommandHandler implements CommandHandler<ModifyUserMembership, Void> {

    private final UserService userService;

    public ModifyUserMembershipCommandHandler(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Void handle(ModifyUserMembership command) {
        userService.modifyUserMembership(command);
        return null;
    }
}
