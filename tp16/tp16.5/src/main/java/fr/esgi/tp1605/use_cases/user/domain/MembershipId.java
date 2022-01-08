package fr.esgi.tp1605.use_cases.user.domain;

import fr.esgi.tp1605.kernel.ValueObjectID;

import java.util.Objects;

public final class MembershipId implements ValueObjectID {

    private final int value;


    public MembershipId(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MembershipId membershipId = (MembershipId) o;
        return value == membershipId.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "MembershipId{" +
                "value=" + value +
                '}';
    }
}
