package com.example.paymentService.dtos.mappers;

import com.example.paymentService.dtos.bills.BillGetDto;
import com.example.paymentService.dtos.bills.BillSlimGetDto;
import com.example.paymentService.dtos.users.UserSlimGetDto;
import com.example.paymentService.models.Bill;

import com.example.paymentService.models.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BillMapper {

    Iterable<BillGetDto> billsToBillsGetDto(Iterable<Bill> bills);
    BillGetDto billToBillGetDto(Bill bill);
    UserSlimGetDto userToUserSlimGetDto(User user);
    BillSlimGetDto billToBillSlimGetDto(Bill bill);

}
