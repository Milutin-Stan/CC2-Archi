package fr.esgi.tp1605.use_cases.payment.application;

import fr.esgi.tp1605.kernel.ApplicationEvent;
import fr.esgi.tp1605.use_cases.payment.domain.PaymentId;
import fr.esgi.tp1605.use_cases.user.domain.Membership;
import fr.esgi.tp1605.use_cases.user.domain.User;

public class CreatePaymentEvent implements ApplicationEvent {
    public final User user;
    public final Membership membership;

    public CreatePaymentEvent(User user, Membership membership) {
        this.user = user;
        this.membership = membership;
    }
}
