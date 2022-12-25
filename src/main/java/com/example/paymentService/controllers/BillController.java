package com.example.paymentService.controllers;

import com.example.paymentService.dtos.bills.BillGetDto;
import com.example.paymentService.dtos.mappers.BillMapper;
import com.example.paymentService.services.interfaces.BillService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/bills")
@Validated
@AllArgsConstructor
public class BillController {

    private final BillService billService;
    private final BillMapper mapper;

    @GetMapping("/{id}")
    public BillGetDto getBill(@PathVariable(name = "id") Long id) {
        return mapper.billToBillGetDto(billService.getBillById(id));
    }

    @GetMapping
    public Iterable<BillGetDto> getBillsOfUser(@RequestParam("user_id") Long userId){
        return mapper.billsToBillsGetDto(billService.getBillsOfUser(userId));
    }

    //feature 2, should be called by separate planner
    //once a month/year (depends on user's payment period)
    @PostMapping
    public BillGetDto createBillOfUser(@RequestParam("user_id") Long userId) {
        return mapper.billToBillGetDto(billService.createBillOfUser(userId));
    }

}
