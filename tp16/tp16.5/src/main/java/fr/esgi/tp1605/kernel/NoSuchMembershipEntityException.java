package fr.esgi.tp1605.kernel;

import fr.esgi.tp1605.use_cases.user.domain.MembershipId;

public class NoSuchMembershipEntityException extends RuntimeException {

    public NoSuchMembershipEntityException(String message) {
        super(message);
    }

    public static NoSuchMembershipEntityException withId(MembershipId id) {
        return new NoSuchMembershipEntityException(String.format("No entity found with ID %d.", id.getValue()));
    }
}
