package fr.esgi.tp1605.use_cases.user.application;

import fr.esgi.tp1605.kernel.Command;
import fr.esgi.tp1605.use_cases.user.domain.Address;
import fr.esgi.tp1605.use_cases.user.domain.Membership;

/**
 * Command object
 */
@SuppressWarnings("all")
public final class CreateUser implements Command {

    public final String lastname;
    public final String firstname;
    public final Address address;
    public Membership membership;

    public CreateUser(String lastname, String firstname, Address address, Membership membership) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.address = address;
        this.membership = membership;
    }
}
