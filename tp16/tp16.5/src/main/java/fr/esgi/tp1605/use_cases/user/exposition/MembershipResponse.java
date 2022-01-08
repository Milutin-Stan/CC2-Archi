package fr.esgi.tp1605.use_cases.user.exposition;

public class MembershipResponse {

    public String name;

    public MembershipResponse(String name) {
        this.name = name;
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
