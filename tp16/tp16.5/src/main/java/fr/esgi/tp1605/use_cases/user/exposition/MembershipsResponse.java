package fr.esgi.tp1605.use_cases.user.exposition;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class MembershipsResponse {

    public final List<MembershipResponse> membershipResponse;

    public MembershipsResponse(List<MembershipResponse> membershipResponse) {
        this.membershipResponse = membershipResponse;
    }
}
