package fr.esgi.tp1605.use_cases.user.application;

import fr.esgi.tp1605.kernel.ApplicationEvent;
import fr.esgi.tp1605.use_cases.user.domain.UserId;

public class ModifyUserMembershipEvent implements ApplicationEvent {
    private final UserId userId;

    public ModifyUserMembershipEvent(UserId userId) {
        this.userId = userId;
    }
}
