package fr.esgi.tp1605.use_cases.user.application;

import fr.esgi.tp1605.kernel.EventListener;

public class CreateMembershipEventListener implements EventListener<CreateMembershipEvent> {
    @Override
    public void listenTo(CreateMembershipEvent event) {
        System.out.println("listening CreateUserEvent.");
    }
}
