package fr.esgi.tp1605.use_cases.payment.application;

import fr.esgi.tp1605.kernel.ApplicationEvent;
import fr.esgi.tp1605.use_cases.payment.domain.PaymentId;
import fr.esgi.tp1605.use_cases.user.domain.Membership;
import fr.esgi.tp1605.use_cases.user.domain.User;

public class CreatePaymentEvent implements ApplicationEvent {
    private final PaymentId paymentId;
    public final User user;
    public final Membership membership;

    public CreatePaymentEvent(PaymentId paymentId, User user, Membership membership) {
        this.paymentId = paymentId;
        this.user = user;
        this.membership = membership;
    }
}
