package fr.esgi.tp1605.use_cases.user.domain;

import fr.esgi.tp1605.kernel.Repository;

import java.util.List;

public interface MembershipRepository extends Repository<MembershipId, Membership> {

    List<Membership> findAll();

    List<Membership> findByName(String name);

}
