package fr.esgi.tp1605.use_cases.user.application;

import fr.esgi.tp1605.kernel.Command;
import fr.esgi.tp1605.use_cases.user.domain.Membership;

public class ModifyUserMembership implements Command {

    public final int userId;
    public final Membership membership;


    public ModifyUserMembership(int userId, Membership membership) {
        this.userId = userId;
        this.membership = membership;
    }
}
