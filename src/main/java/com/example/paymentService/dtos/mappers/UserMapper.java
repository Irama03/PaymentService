package com.example.paymentService.dtos.mappers;

import com.example.paymentService.dtos.users.UserGetDto;
import com.example.paymentService.dtos.users.UserPostDto;
import com.example.paymentService.dtos.users.UserSlimGetDto;
import com.example.paymentService.models.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserGetDto userToUserGetDto(User user);
    UserSlimGetDto userToUserSlimGetDto(User user);

    User userPostDtoToUser(UserPostDto userPostDto);

}
