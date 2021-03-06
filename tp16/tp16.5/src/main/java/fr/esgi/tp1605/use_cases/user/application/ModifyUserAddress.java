package fr.esgi.tp1605.use_cases.user.application;

import fr.esgi.tp1605.kernel.Command;
import fr.esgi.tp1605.use_cases.user.domain.Address;

public class ModifyUserAddress implements Command {

    public final int userId;
    public final Address address;

    public ModifyUserAddress(int userId, Address address) {
        this.userId = userId;
        this.address = address;
    }
}
