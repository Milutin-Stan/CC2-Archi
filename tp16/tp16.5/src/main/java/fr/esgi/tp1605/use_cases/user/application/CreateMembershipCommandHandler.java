package fr.esgi.tp1605.use_cases.user.application;

import fr.esgi.tp1605.kernel.CommandHandler;
import fr.esgi.tp1605.kernel.Event;
import fr.esgi.tp1605.kernel.EventDispatcher;
import fr.esgi.tp1605.use_cases.user.domain.Membership;
import fr.esgi.tp1605.use_cases.user.domain.MembershipId;
import fr.esgi.tp1605.use_cases.user.domain.MembershipRepository;

public final class CreateMembershipCommandHandler implements CommandHandler<CreateMembership, MembershipId> {

    private final MembershipRepository membershipRepository;
    private final EventDispatcher<Event> eventEventDispatcher;

    public CreateMembershipCommandHandler(MembershipRepository membershipRepository, EventDispatcher<Event> eventEventDispatcher) {
        this.membershipRepository = membershipRepository;
        this.eventEventDispatcher = eventEventDispatcher;
    }

    @Override
    public MembershipId handle(CreateMembership createMembership) {
        final MembershipId membershipId = membershipRepository.nextIdentity();
        Membership membership = new Membership(membershipId, createMembership.name, createMembership.startDate, createMembership.endDate, createMembership.isActive, createMembership.prix);
        membershipRepository.add(membership);
        return membershipId;
    }
}
