package fr.esgi.tp1605.use_cases.payment.application;

import fr.esgi.tp1605.kernel.CommandHandler;
import fr.esgi.tp1605.kernel.Event;
import fr.esgi.tp1605.kernel.EventDispatcher;
import fr.esgi.tp1605.use_cases.payment.domain.Payment;
import fr.esgi.tp1605.use_cases.payment.domain.PaymentId;
import fr.esgi.tp1605.use_cases.payment.domain.PaymentRepository;


public class CreatePaymentCommandHandler implements CommandHandler<CreatePayment, PaymentId> {

    private final PaymentRepository paymentRepository;
    private final EventDispatcher<Event> eventDispatcher;


    public CreatePaymentCommandHandler(PaymentRepository paymentRepository, EventDispatcher<Event> eventDispatcher) {
        this.paymentRepository = paymentRepository;
        this.eventDispatcher = eventDispatcher;
    }

    @Override
    public PaymentId handle(CreatePayment createPayment) {
        final PaymentId paymentId = paymentRepository.nextIdentity();
        Payment payment = new Payment(paymentId, createPayment.user, createPayment.membership, createPayment.paymentAccepted);
        paymentRepository.add(payment);
        eventDispatcher.dispatch(new CreatePaymentEvent(createPayment.user, createPayment.membership));
        //eventEventDispatcher.dispatch(new ApplyForNewMembershipEvent(createPayment.user, createPayment.membership));
        //Ceci est un test en plain debug
        //ApplyForNewMembership applyForNewMembership = new ApplyForNewMembership(createPayment.user, createPayment.membership);
        //applyForNewMembership(applyForNewMembership);
        return paymentId;
    }
}
