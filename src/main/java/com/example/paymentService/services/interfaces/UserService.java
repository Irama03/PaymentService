package com.example.paymentService.services.interfaces;

import com.example.paymentService.models.User;

public interface UserService {

    User getUserById(Long id);

    User createUser(User user);

    User banUser(Long id);

}
