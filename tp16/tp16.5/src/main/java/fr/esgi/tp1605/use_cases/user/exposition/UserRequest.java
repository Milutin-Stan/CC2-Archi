package fr.esgi.tp1605.use_cases.user.exposition;

import fr.esgi.tp1605.use_cases.user.domain.Membership;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UserRequest {

    @NotNull
    @NotBlank
    public String lastname;

    @NotNull
    @NotBlank
    public String firstname;

    @NotNull
    public AddressRequest address;

    @NotNull
    public Membership membership;
}
