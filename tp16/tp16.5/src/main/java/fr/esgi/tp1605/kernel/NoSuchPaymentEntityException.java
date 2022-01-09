package fr.esgi.tp1605.kernel;

import fr.esgi.tp1605.use_cases.payment.domain.PaymentId;

public class NoSuchPaymentEntityException extends RuntimeException {

    public NoSuchPaymentEntityException(String message) {
        super(message);
    }

    public static NoSuchPaymentEntityException withId(PaymentId id) {
        return new NoSuchPaymentEntityException(String.format("No entity found with ID %d.", id.getValue()));
    }
}
