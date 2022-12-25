package com.example.paymentService.dtos.bills;

import com.example.paymentService.dtos.transactions.TransactionGetDto;
import com.example.paymentService.dtos.users.UserSlimGetDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
public class BillSlimGetDto {

    @JsonProperty("id")
    @NotNull
    private Long id;

    @JsonProperty("amount")
    @NotNull
    private Double amount;

}
