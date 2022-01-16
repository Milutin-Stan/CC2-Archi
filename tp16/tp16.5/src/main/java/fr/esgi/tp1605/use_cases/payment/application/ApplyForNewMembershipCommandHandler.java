package fr.esgi.tp1605.use_cases.payment.application;

import fr.esgi.tp1605.kernel.CommandHandler;
import fr.esgi.tp1605.kernel.Event;
import fr.esgi.tp1605.kernel.EventDispatcher;
import fr.esgi.tp1605.use_cases.payment.domain.PaymentRepository;

public class ApplyForNewMembershipCommandHandler implements CommandHandler<ApplyForNewMembership, Void> {

    private final PaymentRepository paymentRepository;
    private final EventDispatcher<Event> event;
    private final PaymentService paymentService;

    public ApplyForNewMembershipCommandHandler(PaymentRepository paymentRepository, EventDispatcher<Event> event, PaymentService paymentService) {
        this.paymentRepository = paymentRepository;
        this.event = event;
        this.paymentService = paymentService;
    }

    @Override
    public Void handle(ApplyForNewMembership command) {
        paymentService.applyForNewMembership(command);
        return null;
    }
}
