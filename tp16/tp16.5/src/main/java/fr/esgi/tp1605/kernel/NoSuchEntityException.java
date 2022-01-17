package fr.esgi.tp1605.kernel;

import fr.esgi.tp1605.use_cases.user.domain.UserId;

public final class NoSuchEntityException extends RuntimeException {

    public NoSuchEntityException(String message) {
        super(message);
    }

    public static NoSuchEntityException withId(UserId id) {
        return new NoSuchEntityException(String.format("No entity found with ID %d.", id.getValue()));
    }
}
