package fr.esgi.tp1605.use_cases.payment.exposition;

import fr.esgi.tp1605.use_cases.payment.domain.PaymentId;
import fr.esgi.tp1605.use_cases.user.domain.Membership;
import fr.esgi.tp1605.use_cases.user.domain.User;

public class PaymentResponse {

    public String id;
    public String user;
    public String membership;
    public boolean paymentAccepted;

    public PaymentResponse(String id, String user, String membership, boolean paymentAccepted) {
        this.id = id;
        this.user = user;
        this.membership = membership;
        this.paymentAccepted = paymentAccepted;
    }

    @Override
    public String toString() {
        return "Payments{" +
                "id=" + id +
                ", User='" + user + '\'' +
                ", Membership='" + membership  + '\'' +
                ", paymentAccepted=" + paymentAccepted +
                '}';
    }
}
