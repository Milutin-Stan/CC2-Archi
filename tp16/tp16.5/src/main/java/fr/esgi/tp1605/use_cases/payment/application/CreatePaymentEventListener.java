package fr.esgi.tp1605.use_cases.payment.application;

import fr.esgi.tp1605.kernel.EventListener;
import fr.esgi.tp1605.use_cases.user.application.ModifyUserMembership;
import fr.esgi.tp1605.use_cases.user.application.ModifyUserMembershipCommandHandler;

public class CreatePaymentEventListener implements EventListener<CreatePaymentEvent> {

    private final ModifyUserMembershipCommandHandler modifyUserMembershipCommandHandler;

    public CreatePaymentEventListener(ModifyUserMembershipCommandHandler modifyUserMembershipCommandHandler) {
        this.modifyUserMembershipCommandHandler = modifyUserMembershipCommandHandler;
    }

    @Override
    public void listenTo(CreatePaymentEvent event) {
        System.out.println("listening CreatePaymentEvent.");
        ModifyUserMembership modifyUserMembership = new ModifyUserMembership(event.user.id().getValue(), event.membership);
        modifyUserMembershipCommandHandler.handle(modifyUserMembership);
    }
}
