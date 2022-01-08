package fr.esgi.tp1605;

import fr.esgi.tp1605.use_cases.user.application.*;
import fr.esgi.tp1605.use_cases.user.domain.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class SpringMain {
    public static void main(String[] args) throws ParseException {
        final ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringMain.class, args);


        //-5. Create default free  Membership
        CreateMembershipCommandHandler membershipCommandHandler = applicationContext.getBean(CreateMembershipCommandHandler.class);
        Date start = new SimpleDateFormat("dd/MM/yyyy").parse("01/02/2021");
        Date end = new SimpleDateFormat("dd/MM/yyyy").parse("01/02/2022");
        CreateMembership createMembership = new CreateMembership("FREE", start, end, false, 0);
        final MembershipId membershipId = membershipCommandHandler.handle(createMembership);
        Membership membership = new Membership(membershipId, createMembership.name, createMembership.startDate, createMembership.endDate, createMembership.isActive, createMembership.prix);
        System.out.println((membership.toString()));

        //--1. Create User
        CreateUserCommandHandler userCommandHandler = applicationContext.getBean(CreateUserCommandHandler.class);
        CreateUser createUser = new CreateUser("BOISSINOT", "GREGORY", new Address("PARIS"), membership);
        final UserId userId = userCommandHandler.handle(createUser);

        //--2. Modify User Address
        ModifyUserAddressCommandHandler modifyUserAddressCommandHandler = applicationContext.getBean(ModifyUserAddressCommandHandler.class);
        modifyUserAddressCommandHandler.handle(new ModifyUserAddress(userId.getValue(), new Address("ALFORTVILLE")));

        //--3. Retrieve all users
        RetrieveUsers retrieveUsers = new RetrieveUsers();
        RetrieveUsersHandler retrieveUsersHandler = applicationContext.getBean(RetrieveUsersHandler.class);
        final List<User> users = retrieveUsersHandler.handle(retrieveUsers);
        users.forEach(System.out::println);

        //--4. Retrieve user with ALFORTVILLE city
        RetrieveUsersByCity retrieveUsersByCity = new RetrieveUsersByCity("ALFORTVILLE");
        RetrieveUsersByCityHandler retrieveUsersByCityHandler = applicationContext.getBean(RetrieveUsersByCityHandler.class);
        final List<User> searchedUsers = retrieveUsersByCityHandler.handle(retrieveUsersByCity);
        searchedUsers.forEach(System.out::println);
    }
}
