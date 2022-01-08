package fr.esgi.tp1605.use_cases.user.infrastructure;

import fr.esgi.tp1605.kernel.NoSuchMembershipEntityException;
import fr.esgi.tp1605.use_cases.user.domain.Membership;
import fr.esgi.tp1605.use_cases.user.domain.MembershipId;
import fr.esgi.tp1605.use_cases.user.domain.MembershipRepository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public final class InMemoryMemberRepository implements MembershipRepository {

    private final AtomicInteger count = new AtomicInteger(0);

    private final Map<MembershipId, Membership> data = new ConcurrentHashMap<>();

    @Override
    public MembershipId nextIdentity() {
        return new MembershipId(count.incrementAndGet());
    }

    @Override
    public Membership findById(MembershipId id) {
        final Membership membership = data.get(id);
        if (membership == null) {
            throw NoSuchMembershipEntityException.withId(id);
        }
        return membership;
    }

    @Override
    public void add(Membership membership) {
        data.put(membership.id(), membership);
    }

    @Override
    public void delete(MembershipId id) {
        data.remove(id);
    }

    @Override
    public List<Membership> findAll() {
        return List.copyOf(data.values());
    }

    @Override
    public List<Membership> findByName(String name) {
        return List.copyOf(data.values().stream()
                .filter(membership -> membership.getName().equalsIgnoreCase(name)).collect(Collectors.toList()));
    }

}
