package com.example.paymentService.dtos.users;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class UserSlimGetDto {

    @JsonProperty("id")
    @NotNull
    private Long id;

    @JsonProperty("tariff")
    @NotNull
    private Double tariff;
}
