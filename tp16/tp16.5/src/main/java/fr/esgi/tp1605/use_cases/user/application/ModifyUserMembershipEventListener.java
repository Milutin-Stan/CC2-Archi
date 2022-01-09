package fr.esgi.tp1605.use_cases.user.application;

import fr.esgi.tp1605.kernel.EventListener;

public class ModifyUserMembershipEventListener implements EventListener<ModifyUserMembershipEvent> {
    @Override
    public void listenTo(ModifyUserMembershipEvent event) {
        System.out.println("Listening ModifyUserMembershipEvent.");
    }
}
