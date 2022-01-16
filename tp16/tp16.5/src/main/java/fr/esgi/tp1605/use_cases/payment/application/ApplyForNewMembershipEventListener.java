package fr.esgi.tp1605.use_cases.payment.application;

import fr.esgi.tp1605.kernel.CommandBus;
import fr.esgi.tp1605.kernel.EventListener;
import fr.esgi.tp1605.use_cases.user.application.ModifyUserMembership;
import fr.esgi.tp1605.use_cases.user.application.UserService;

public class ApplyForNewMembershipEventListener implements EventListener<ApplyForNewMembershipEvent> {

    private UserService userService;

    public ApplyForNewMembershipEventListener(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void listenTo(ApplyForNewMembershipEvent event) {
        System.out.println("listening ApplyForNewMembershipEvent.");
        ModifyUserMembership modifyUserMembership = new ModifyUserMembership(event.user.id().getValue(), event.membership);
        userService.modifyUserMembership(modifyUserMembership);
    }
}
