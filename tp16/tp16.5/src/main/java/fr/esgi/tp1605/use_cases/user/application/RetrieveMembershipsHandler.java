package fr.esgi.tp1605.use_cases.user.application;

import fr.esgi.tp1605.kernel.QueryHandler;
import fr.esgi.tp1605.use_cases.user.domain.Membership;
import fr.esgi.tp1605.use_cases.user.domain.MembershipRepository;
import fr.esgi.tp1605.use_cases.user.domain.UserRepository;
import fr.esgi.tp1605.use_cases.user.exposition.MembershipResponse;

import java.util.List;

public class RetrieveMembershipsHandler implements QueryHandler<RetrieveMemberships, List<Membership>> {

    private MembershipRepository membershipRepository;

    public RetrieveMembershipsHandler(MembershipRepository membershipRepository) {
        this.membershipRepository = membershipRepository;
    }

    @Override
    public List<Membership> handle(RetrieveMemberships query) {
        return membershipRepository.findAll();
    }
}
