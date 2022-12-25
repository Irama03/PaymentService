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
public class BillGetDto {

    @JsonProperty("id")
    @NotNull
    private Long id;

    @JsonProperty("user")
    @NotNull
    private UserSlimGetDto user;

    @JsonProperty("amount")
    @NotNull
    private Double amount;

    @JsonProperty("creationDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @NotNull
    private Date creationDate;

    @JsonProperty("paymentDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date paymentDate;

    @JsonProperty("transactions")
    private Set<TransactionGetDto> transactions;

}
