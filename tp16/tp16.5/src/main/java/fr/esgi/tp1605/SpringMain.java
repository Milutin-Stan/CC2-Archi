package fr.esgi.tp1605;

import fr.esgi.tp1605.kernel.CommandBus;
import fr.esgi.tp1605.use_cases.payment.application.ApplyForNewMembership;
import fr.esgi.tp1605.use_cases.payment.application.ApplyForNewMembershipCommandHandler;
import fr.esgi.tp1605.use_cases.payment.application.CreatePayment;
import fr.esgi.tp1605.use_cases.payment.application.CreatePaymentCommandHandler;
import fr.esgi.tp1605.use_cases.payment.domain.PaymentId;
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

        CommandBus paymentCommandBus = applicationContext.getBean(CommandBus.class);

        //-0. Create default free Membership
        CreateMembershipCommandHandler membershipCommandHandler = applicationContext.getBean(CreateMembershipCommandHandler.class);
        Date start = new SimpleDateFormat("dd/MM/yyyy").parse("01/02/2021");
        Date end = new SimpleDateFormat("dd/MM/yyyy").parse("01/02/2022");
        CreateMembership createMembership = new CreateMembership("FREE", start, end, false, 0);
        final MembershipId membershipId = membershipCommandHandler.handle(createMembership);

        Membership membership = new Membership(membershipId, createMembership.name, createMembership.startDate, createMembership.endDate, createMembership.isActive, createMembership.prix);
        System.out.println((membership.toString()));

        //--1. Create User
        CreateUserCommandHandler userCommandHandler = applicationContext.getBean(CreateUserCommandHandler.class);
        CreateUser createUser = new CreateUser("STANOJEVIC", "MILUTIN", new Address("PARIS"), membership);
        final UserId userId = userCommandHandler.handle(createUser);
        User user = new User(userId, createUser.lastname, createUser.firstname, createUser.address, createUser.membership);

        //--2. Modify User Address
        ModifyUserAddressCommandHandler modifyUserAddressCommandHandler = applicationContext.getBean(ModifyUserAddressCommandHandler.class);
        modifyUserAddressCommandHandler.handle(new ModifyUserAddress(userId.getValue(), new Address("NICE")));

        //--3. Retrieve all users
        RetrieveUsers retrieveUsers = new RetrieveUsers();
        RetrieveUsersHandler retrieveUsersHandler = applicationContext.getBean(RetrieveUsersHandler.class);
        final List<User> users = retrieveUsersHandler.handle(retrieveUsers);
        users.forEach(System.out::println);

        //--4. Retrieve user with ALFORTVILLE city
        RetrieveUsersByCity retrieveUsersByCity = new RetrieveUsersByCity("NICE");
        RetrieveUsersByCityHandler retrieveUsersByCityHandler = applicationContext.getBean(RetrieveUsersByCityHandler.class);
        final List<User> searchedUsers = retrieveUsersByCityHandler.handle(retrieveUsersByCity);
        searchedUsers.forEach(System.out::println);

        //-5. Create new Membership

        CreateMembership createNewMembership = new CreateMembership("PRO", start, end, false, 100);
        final MembershipId membershipId1 = membershipCommandHandler.handle(createNewMembership);
        Membership newMembership = new Membership(membershipId1, createNewMembership.name, createNewMembership.startDate, createNewMembership.endDate, createNewMembership.isActive, createNewMembership.prix);
        System.out.println((newMembership.toString()));

        //-6 Create New Payment (On dit que le payment est passé)
        CreatePaymentCommandHandler createPaymentCommandHandler = applicationContext.getBean(CreatePaymentCommandHandler.class);
        CreatePayment createPayment = new CreatePayment(user,newMembership,true);
        PaymentId paymentId = paymentCommandBus.send(createPayment);
        //PaymentId paymentId = createPaymentCommandHandler.handle(createPayment);

        //-6 Apply For New Membership
        //ApplyForNewMembership applyForNewMembership = new ApplyForNewMembership(user,newMembership);
        //paymentCommandBus.send(applyForNewMembership);
        //System.out.println(user.toString());

        //-7 Modify User Membership
        //ModifyUserMembership modifyUserMembership = new ModifyUserMembership(user.id().getValue(), newMembership);
        //paymentCommandBus.send(modifyUserMembership);
        //System.out.println(user.toString());
    }
}
