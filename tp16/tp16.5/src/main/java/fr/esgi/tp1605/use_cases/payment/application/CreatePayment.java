package fr.esgi.tp1605.use_cases.payment.application;

import fr.esgi.tp1605.kernel.Command;
import fr.esgi.tp1605.use_cases.user.domain.Membership;
import fr.esgi.tp1605.use_cases.user.domain.User;

public class CreatePayment implements Command {

    public User user;
    public Membership membership;
    public boolean paymentAccepted;

    public CreatePayment(User user, Membership membership, boolean paymentAccepted) {
        this.user = user;
        this.membership = membership;
        this.paymentAccepted = paymentAccepted;
    }
}
