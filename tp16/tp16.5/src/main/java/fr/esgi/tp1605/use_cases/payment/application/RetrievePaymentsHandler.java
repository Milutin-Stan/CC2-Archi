package fr.esgi.tp1605.use_cases.payment.application;

import fr.esgi.tp1605.kernel.QueryHandler;
import fr.esgi.tp1605.use_cases.payment.domain.Payment;
import fr.esgi.tp1605.use_cases.payment.domain.PaymentRepository;

import java.util.List;

public class RetrievePaymentsHandler implements QueryHandler<RetrievePayments, List<Payment>> {

    private PaymentRepository paymentRepository;

    public RetrievePaymentsHandler(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public List<Payment> handle(RetrievePayments query) {

        return paymentRepository.findAll();
    }
}
