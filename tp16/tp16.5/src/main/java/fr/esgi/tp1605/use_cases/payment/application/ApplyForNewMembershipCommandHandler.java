package fr.esgi.tp1605.use_cases.payment.application;

import fr.esgi.tp1605.kernel.CommandHandler;
import fr.esgi.tp1605.kernel.Event;
import fr.esgi.tp1605.kernel.EventDispatcher;
import fr.esgi.tp1605.use_cases.payment.domain.PaymentId;
import fr.esgi.tp1605.use_cases.payment.domain.PaymentRepository;
import fr.esgi.tp1605.use_cases.user.domain.UserId;
import fr.esgi.tp1605.use_cases.user.domain.UserRepository;

public class ApplyForNewMembershipCommandHandler implements CommandHandler<ApplyForNewMembership, Void> {

    private final PaymentRepository paymentRepository;
    private final EventDispatcher<Event> event;

    public ApplyForNewMembershipCommandHandler(PaymentRepository paymentRepository, EventDispatcher<Event> event) {
        this.paymentRepository = paymentRepository;
        this.event = event;
    }

    @Override
    public Void handle(ApplyForNewMembership command) {
        var paymentId = new PaymentId(command.user.id().getValue());
        var payment = paymentRepository.findById(paymentId);
        paymentRepository.add(payment);
        return null;
    }
}
