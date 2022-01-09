package fr.esgi.tp1605.use_cases.payment.domain;

import fr.esgi.tp1605.kernel.ValueObjectID;

import java.util.Objects;

public class PaymentId implements ValueObjectID {

    private final int value;

    public PaymentId(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentId paymentId = (PaymentId) o;
        return value == paymentId.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "PaymentId{" +
                "value=" + value +
                '}';
    }
}
