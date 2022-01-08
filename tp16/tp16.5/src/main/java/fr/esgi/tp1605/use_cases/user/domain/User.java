package fr.esgi.tp1605.use_cases.user.domain;


import fr.esgi.tp1605.kernel.Entity;

import java.util.Objects;

public final class User implements Entity<UserId> {

    private final UserId id;
    private final String lastname;
    private final String firstname;
    private Address address;
    private Membership membership;

    public User(UserId id, String lastname, String firstname, Address address, Membership membership) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.address = address;
        this.membership = membership;
    }

    public UserId getId() {
        return id;
    }

    @Override
    public UserId id() {
        return id;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public Address getAddress() {
        return address;
    }

    public Membership getMembership() {
        return membership;
    }

    public void setMembership(Membership membership) {
        this.membership = membership;
    }

    public void changeAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(lastname, user.lastname) && Objects.equals(firstname, user.firstname) && Objects.equals(address, user.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastname, firstname, address);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", address=" + address + '\'' +
                ", membership=" + membership.getName() +
                '}';
    }
}
