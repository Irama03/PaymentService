package com.example.paymentService.apiCommunication;

import com.example.paymentService.models.User;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class PlannerWebClient {

    private final WebClient webClient;

    private static final String PLANNER_URL = "http://planner_service.com/plan_bills_payment";

    public void planBillsPaymentForANewUser(User user) {
        //perform http call to endpoint
        this.webClient.post()
                .uri(PLANNER_URL)
                .body(Mono.just(user), User.class)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve();
    }
}
