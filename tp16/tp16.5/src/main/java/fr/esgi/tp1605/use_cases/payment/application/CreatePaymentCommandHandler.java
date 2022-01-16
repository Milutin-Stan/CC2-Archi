package fr.esgi.tp1605.use_cases.payment.application;

import fr.esgi.tp1605.kernel.CommandHandler;
import fr.esgi.tp1605.kernel.Event;
import fr.esgi.tp1605.kernel.EventDispatcher;
import fr.esgi.tp1605.use_cases.payment.domain.Payment;
import fr.esgi.tp1605.use_cases.payment.domain.PaymentId;
import fr.esgi.tp1605.use_cases.payment.domain.PaymentRepository;

public class CreatePaymentCommandHandler implements CommandHandler<CreatePayment, PaymentId> {

    private PaymentService paymentService;

    public CreatePaymentCommandHandler(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Override
    public PaymentId handle(CreatePayment createPayment) {
        return paymentService.createPayment(createPayment);
    }
}
