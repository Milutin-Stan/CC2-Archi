package fr.esgi.tp1605.use_cases.payment.exposition;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class PaymentsResponse {

    public final List<PaymentResponse> payments;


    public PaymentsResponse(List<PaymentResponse> payments) {
        this.payments = payments;
    }
}
