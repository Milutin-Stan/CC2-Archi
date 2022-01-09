package fr.esgi.tp1605.use_cases.payment.application;

import fr.esgi.tp1605.kernel.EventListener;

public class ApplyForNewMembershipEventListener implements EventListener<ApplyForNewMembershipEvent> {


    @Override
    public void listenTo(ApplyForNewMembershipEvent event) {
        System.out.println("listening ApplyForNewMembershipEvent.");
    }
}
