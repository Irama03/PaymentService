package com.example.paymentService.controllers;

import com.example.paymentService.dtos.users.UserGetDto;
import com.example.paymentService.dtos.users.UserPostDto;
import com.example.paymentService.dtos.mappers.UserMapper;
import com.example.paymentService.services.interfaces.UserService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api/users")
@Validated
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper mapper;

    @GetMapping("/{id}")
    public UserGetDto getUser(@PathVariable(name = "id") Long id) {
        return mapper.userToUserGetDto(userService.getUserById(id));
    }

    //feature 1, should be called by user
    @PostMapping
    public UserGetDto createUser(@Valid @RequestBody UserPostDto dto) {
        return mapper.userToUserGetDto(userService.createUser(mapper.userPostDtoToUser(dto)));
    }

    //feature 5, should be called by separate planner
    @PatchMapping("/{id}/ban")
    public UserGetDto banUser(@PathVariable(name = "id") Long id) {
        return mapper.userToUserGetDto(userService.banUser(id));
    }

}
