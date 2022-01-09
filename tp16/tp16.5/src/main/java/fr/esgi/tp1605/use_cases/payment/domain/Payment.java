package fr.esgi.tp1605.use_cases.payment.domain;

import fr.esgi.tp1605.kernel.Entity;
import fr.esgi.tp1605.use_cases.user.domain.Membership;
import fr.esgi.tp1605.use_cases.user.domain.User;

public class Payment implements Entity<PaymentId>{

    private PaymentId id;
    private User user;
    private Membership membership;
    private boolean paymentAccepted;

    public Payment(PaymentId id, User user, Membership membership, boolean paymentAccepted) {
        this.id = id;
        this.user = user;
        this.membership = membership;
        this.paymentAccepted = paymentAccepted;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Membership getMembership() {
        return membership;
    }

    public void setMembership(Membership membership) {
        this.membership = membership;
    }

    public boolean isPaymentAccepted() {
        return paymentAccepted;
    }

    public void setPaymentAccepted(boolean paymentAccepted) {
        this.paymentAccepted = paymentAccepted;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", User='" + user.getFirstname() + '\'' +
                ", Membership='" + membership.getName() + '\'' +
                ", paymentAccepted=" + paymentAccepted +
                '}';
    }

    @Override
    public PaymentId id() {
        return id;
    }
}
