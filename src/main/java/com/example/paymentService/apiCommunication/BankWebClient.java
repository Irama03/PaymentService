package com.example.paymentService.apiCommunication;

import com.example.paymentService.dtos.bills.BillForPaymentDto;
import com.example.paymentService.models.Bill;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class BankWebClient {

    private final WebClient webClient;

    private static final String BANK_URL = "http://some_bank.com/pay_bill";

    public boolean tryToPayBill(Bill bill) {
        BillForPaymentDto billForPaymentDto =
                new BillForPaymentDto(bill.getId(), bill.getAmount(), bill.getUser().getCard());
        //perform http call to endpoint
        //expect to return true if successful transaction, false if not successful
        return Boolean.TRUE.equals(this.webClient.post()
                .uri(BANK_URL)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(billForPaymentDto), BillForPaymentDto.class)
                .retrieve()
                .bodyToMono(Boolean.class)
                .block());
    }

}
