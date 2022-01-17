package fr.esgi.tp1605.use_cases.user.exposition;

import fr.esgi.tp1605.use_cases.user.application.*;
import fr.esgi.tp1605.use_cases.user.domain.Address;
import fr.esgi.tp1605.use_cases.user.domain.Membership;
import fr.esgi.tp1605.use_cases.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/users")
public class UserController {

    private final CreateUserCommandHandler createUserCommandHandler;
    private final RetrieveUsersHandler retrieveUsersHandler;
    private final RetrieveUsersByCityHandler retrieveUsersByCityHandler;
    private final CreateMembershipCommandHandler createMemvershipCommandHandler;
    private final RetrieveMembershipsHandler retrieveMembershipsHandler;

    @Autowired
    private UserController(CreateUserCommandHandler createUserCommandHandler, RetrieveUsersHandler retrieveUsersHandler, RetrieveUsersByCityHandler retrieveUsersByCityHandler, CreateMembershipCommandHandler createMemvershipCommandHandler, RetrieveMembershipsHandler retrieveMembershipsHandler) {
        this.createUserCommandHandler = createUserCommandHandler;
        this.retrieveUsersHandler = retrieveUsersHandler;
        this.retrieveUsersByCityHandler = retrieveUsersByCityHandler;
        this.createMemvershipCommandHandler = createMemvershipCommandHandler;
        this.retrieveMembershipsHandler = retrieveMembershipsHandler;
    }

    @GetMapping(produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UsersResponse> getAll() {
        final List<User> users = retrieveUsersHandler.handle(new RetrieveUsers());
        UsersResponse usersResponseResult = new UsersResponse(users.stream().map(user -> new UserResponse(String.valueOf(user.getId().getValue()), user.getFirstname(),
                new AddressResponse(user.getAddress().getCity()),
                new MembershipResponse(user.getMembership().getName()))).collect(Collectors.toList()));
        return ResponseEntity.ok(usersResponseResult);
    }

    @GetMapping(path = "/cities/{city}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UsersResponse> getUsersByCity(@PathVariable("city") String city) {
        final List<User> users = retrieveUsersByCityHandler.handle(new RetrieveUsersByCity(city));
        UsersResponse usersResponseResult = new UsersResponse(users.stream().map(user -> new UserResponse(String.valueOf(user.getId().getValue()), user.getFirstname(),
                new AddressResponse(user.getAddress().getCity()),
                new MembershipResponse(user.getMembership().getName()))).collect(Collectors.toList()));
        return ResponseEntity.ok(usersResponseResult);
    }

    @PostMapping(path="/membership/create",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<MembershipResponse> getMembershipByName(@RequestBody @Valid MembershipRequest membershipRequest) throws ParseException {
        Date start = new SimpleDateFormat("dd/MM/yyyy").parse("01/02/2021");
        Date end = new SimpleDateFormat("dd/MM/yyyy").parse("01/02/2022");
        CreateMembership createMembership = new CreateMembership(membershipRequest.name,start,end,true,0.0);
        createMemvershipCommandHandler.handle(createMembership);
        return ResponseEntity.ok(null);
    }

    @GetMapping(path = "/memberships" , produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<MembershipsResponse> getAllMemberships(){
        final List<Membership> memberships = retrieveMembershipsHandler.handle(new RetrieveMemberships());
        MembershipsResponse membershipsResponse = new MembershipsResponse(memberships.stream().map(membership -> new MembershipResponse(String.valueOf(membership.getName()))).collect(Collectors.toList()));
        return ResponseEntity.ok(membershipsResponse);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> create(@RequestBody @Valid UserRequest request) {
        CreateUser createUser = new CreateUser(request.lastname, request.firstname, new Address(request.address.city), request.membership);
        createUserCommandHandler.handle(createUser);
        return ResponseEntity.ok(null);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchCityException.class)
    public void handleNoSuchCityException() {
        //empty
    }
}
