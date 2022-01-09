package fr.esgi.tp1605.use_cases.payment.application;

import fr.esgi.tp1605.kernel.ApplicationEvent;
import fr.esgi.tp1605.use_cases.payment.domain.PaymentId;

public class CreatePaymentEvent implements ApplicationEvent {
    private final PaymentId paymentId;

    public CreatePaymentEvent(PaymentId paymentId) {
        this.paymentId = paymentId;
    }
}
