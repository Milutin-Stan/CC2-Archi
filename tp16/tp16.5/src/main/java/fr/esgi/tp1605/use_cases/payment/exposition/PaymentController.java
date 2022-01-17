package fr.esgi.tp1605.use_cases.payment.exposition;

import fr.esgi.tp1605.use_cases.payment.application.RetrievePayments;
import fr.esgi.tp1605.use_cases.payment.application.RetrievePaymentsHandler;
import fr.esgi.tp1605.use_cases.payment.domain.Payment;
import fr.esgi.tp1605.use_cases.user.application.RetrieveUsers;
import fr.esgi.tp1605.use_cases.user.domain.User;
import fr.esgi.tp1605.use_cases.user.exposition.AddressResponse;
import fr.esgi.tp1605.use_cases.user.exposition.MembershipResponse;
import fr.esgi.tp1605.use_cases.user.exposition.UserResponse;
import fr.esgi.tp1605.use_cases.user.exposition.UsersResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private RetrievePaymentsHandler retrievePaymentsHandler;

    public PaymentController(RetrievePaymentsHandler retrievePaymentsHandler) {
        this.retrievePaymentsHandler = retrievePaymentsHandler;
    }

    @GetMapping(produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<PaymentsResponse> getAllPayments() {
        final List<Payment> payments = retrievePaymentsHandler.handle(new RetrievePayments());
        PaymentsResponse paymentsResponse = new PaymentsResponse(payments.stream().map(payment ->
                new PaymentResponse(String.valueOf(payment.id()),
                    payment.getUser().getFirstname(),
                    payment.getMembership().getName(),
                        payment.isPaymentAccepted())).collect(Collectors.toList()));
        return ResponseEntity.ok(paymentsResponse);
    }


}
