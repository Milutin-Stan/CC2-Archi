package fr.esgi.tp1605.use_cases.user.exposition;

public class MembershipRequest {

    public String name;

    public MembershipRequest(String name) {
        this.name = name;
    }

    public MembershipRequest() {
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MembershipDTO{" +
                "name='" + name + '\'' +
                '}';
    }
}
