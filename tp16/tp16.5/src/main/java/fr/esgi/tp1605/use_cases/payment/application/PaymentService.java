package fr.esgi.tp1605.use_cases.payment.application;

import fr.esgi.tp1605.kernel.Event;
import fr.esgi.tp1605.kernel.EventDispatcher;
import fr.esgi.tp1605.use_cases.payment.domain.Payment;
import fr.esgi.tp1605.use_cases.payment.domain.PaymentId;
import fr.esgi.tp1605.use_cases.payment.domain.PaymentRepository;

public class PaymentService {

    private PaymentRepository paymentRepository;
    private EventDispatcher<Event> eventEventDispatcher;

    public PaymentService(PaymentRepository paymentRepository, EventDispatcher<Event> eventEventDispatcher) {
        this.paymentRepository = paymentRepository;
        this.eventEventDispatcher = eventEventDispatcher;
    }

    public PaymentId createPayment(CreatePayment createPayment){
        final PaymentId paymentId = paymentRepository.nextIdentity();
        Payment payment = new Payment(paymentId, createPayment.user, createPayment.membership, createPayment.paymentAccepted);
        paymentRepository.add(payment);
        eventEventDispatcher.dispatch(new CreatePaymentEvent(paymentId, createPayment.user, createPayment.membership));
        return paymentId;
    }


    public Void applyForNewMembership(ApplyForNewMembership command){
        var paymentId = new PaymentId(command.user.id().getValue());
        var payment = paymentRepository.findById(paymentId);
        paymentRepository.add(payment);
        eventEventDispatcher.dispatch(new ApplyForNewMembershipEvent(paymentId));
        return null;
    }

}
