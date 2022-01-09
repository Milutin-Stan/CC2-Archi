package fr.esgi.tp1605.use_cases.payment.application;

import fr.esgi.tp1605.kernel.ApplicationEvent;
import fr.esgi.tp1605.use_cases.payment.domain.PaymentId;

public class ApplyForNewMembershipEvent implements ApplicationEvent {
    private final PaymentId paymentId;


    public ApplyForNewMembershipEvent(PaymentId paymentId) {
        this.paymentId = paymentId;
    }
}
