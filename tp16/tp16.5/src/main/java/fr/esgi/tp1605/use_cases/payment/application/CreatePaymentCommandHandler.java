package fr.esgi.tp1605.use_cases.payment.application;

import fr.esgi.tp1605.kernel.CommandHandler;
import fr.esgi.tp1605.kernel.Event;
import fr.esgi.tp1605.kernel.EventDispatcher;
import fr.esgi.tp1605.use_cases.payment.domain.Payment;
import fr.esgi.tp1605.use_cases.payment.domain.PaymentId;
import fr.esgi.tp1605.use_cases.payment.domain.PaymentRepository;
import fr.esgi.tp1605.use_cases.user.application.CreateMembership;
import fr.esgi.tp1605.use_cases.user.application.CreateMembershipEvent;
import fr.esgi.tp1605.use_cases.user.domain.Membership;
import fr.esgi.tp1605.use_cases.user.domain.MembershipId;

public class CreatePaymentCommandHandler implements CommandHandler<CreatePayment, PaymentId> {

    private PaymentRepository paymentRepository;
    private EventDispatcher<Event> eventEventDispatcher;

    public CreatePaymentCommandHandler(PaymentRepository paymentRepository, EventDispatcher<Event> eventEventDispatcher) {
        this.paymentRepository = paymentRepository;
        this.eventEventDispatcher = eventEventDispatcher;
    }

    @Override
    public PaymentId handle(CreatePayment createPayment) {
        final PaymentId paymentId = paymentRepository.nextIdentity();
        Payment payment = new Payment(paymentId, createPayment.user, createPayment.membership, createPayment.paymentAccepted);
        paymentRepository.add(payment);
        return paymentId;
    }
}
