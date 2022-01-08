package fr.esgi.tp1605.use_cases.user.application;

import fr.esgi.tp1605.kernel.ApplicationEvent;
import fr.esgi.tp1605.use_cases.user.domain.MembershipId;

public class CreateMembershipEvent implements ApplicationEvent {
    private final MembershipId membershipId;

    public CreateMembershipEvent(MembershipId membershipId) {
        this.membershipId = membershipId;
    }
}
