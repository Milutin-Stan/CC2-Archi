package fr.esgi.tp1605.use_cases.payment.application;

import fr.esgi.tp1605.kernel.Command;
import fr.esgi.tp1605.use_cases.user.domain.Membership;
import fr.esgi.tp1605.use_cases.user.domain.User;

public class ApplyForNewMembership implements Command {

    public User user;
    public Membership membership;

    public ApplyForNewMembership(User user, Membership membership) {
        this.user = user;
        this.membership = membership;
    }
}
