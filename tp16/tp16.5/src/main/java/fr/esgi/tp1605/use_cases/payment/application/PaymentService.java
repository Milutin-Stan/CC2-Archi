package fr.esgi.tp1605.use_cases.payment.application;

import fr.esgi.tp1605.kernel.Event;
import fr.esgi.tp1605.kernel.EventDispatcher;
import fr.esgi.tp1605.use_cases.payment.domain.Payment;
import fr.esgi.tp1605.use_cases.payment.domain.PaymentId;
import fr.esgi.tp1605.use_cases.payment.domain.PaymentRepository;
import fr.esgi.tp1605.use_cases.user.application.UserService;

public class PaymentService {

    private PaymentRepository paymentRepository;
    private UserService userService;
    private EventDispatcher<Event> eventEventDispatcher;

    public PaymentService(PaymentRepository paymentRepository, EventDispatcher<Event> eventEventDispatcher) {
        this.paymentRepository = paymentRepository;
        this.eventEventDispatcher = eventEventDispatcher;
    }

    public PaymentId createPayment(CreatePayment createPayment){
        final PaymentId paymentId = paymentRepository.nextIdentity();
        Payment payment = new Payment(paymentId, createPayment.user, createPayment.membership, createPayment.paymentAccepted);
        paymentRepository.add(payment);
        eventEventDispatcher.dispatch(new CreatePaymentEvent(createPayment.user, createPayment.membership));
        //Ceci est un test en plain debug
        ApplyForNewMembership applyForNewMembership = new ApplyForNewMembership(createPayment.user, createPayment.membership);
        applyForNewMembership(applyForNewMembership);
        return paymentId;
    }


    public Void applyForNewMembership(ApplyForNewMembership command){
        eventEventDispatcher.dispatch(new ApplyForNewMembershipEvent(command.user, command.membership));
        return null;
    }

}
