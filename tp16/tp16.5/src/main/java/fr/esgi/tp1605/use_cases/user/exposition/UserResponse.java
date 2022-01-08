package fr.esgi.tp1605.use_cases.user.exposition;

@SuppressWarnings("all")
public class UserResponse {

    public final String id;
    //no lastname explicitly
    public final String firstname;
    public final AddressResponse address;
    public final MembershipResponse membership;

    public UserResponse(String id, String firstname, AddressResponse address, MembershipResponse membership) {
        this.id = id;
        this.firstname = firstname;
        this.address = address;
        this.membership = membership;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", address=" + address + '\'' +
                ", membership=" + membership +
                '}';
    }
}
