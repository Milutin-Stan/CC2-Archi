package fr.esgi.tp1605.use_cases.payment.application;

import fr.esgi.tp1605.kernel.EventListener;

public class CreatePaymentEventListener implements EventListener<CreatePaymentEvent> {

    @Override
    public void listenTo(CreatePaymentEvent event) {
        System.out.println("listening CreatePaymentEvent.");
    }
}
