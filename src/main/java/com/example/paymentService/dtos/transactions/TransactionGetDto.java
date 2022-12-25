package com.example.paymentService.dtos.transactions;

import com.example.paymentService.dtos.bills.BillSlimGetDto;
import com.example.paymentService.models.Bill;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
public class TransactionGetDto {

    @JsonProperty("id")
    @NotNull
    private Long id;

    @JsonProperty("bill")
    @NotNull
    private BillSlimGetDto bill;

    @JsonProperty("processDate")
    @NotNull
    private Date processDate;

    @JsonProperty("isSuccessful")
    @NotNull
    private Boolean isSuccessful;

}
