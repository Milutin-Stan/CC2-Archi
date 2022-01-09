package fr.esgi.tp1605.use_cases.payment.domain;

import fr.esgi.tp1605.kernel.Repository;
import fr.esgi.tp1605.use_cases.user.domain.Membership;

import java.util.List;

public interface PaymentRepository extends Repository<PaymentId, Payment> {

    List<Payment> findAll();

}
