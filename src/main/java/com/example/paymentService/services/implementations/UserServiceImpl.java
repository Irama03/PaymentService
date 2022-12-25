package com.example.paymentService.services.implementations;

import com.example.paymentService.apiCommunication.PlannerWebClient;
import com.example.paymentService.exceptions.RecordNotFoundException;
import com.example.paymentService.models.User;
import com.example.paymentService.repositories.UserRepository;
import com.example.paymentService.services.interfaces.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private PlannerWebClient plannerWebClient;

    @Override
    public User getUserById(Long id) {
        return userRepository
                .findById(id)
                .orElseThrow(() -> new RecordNotFoundException(User.class, "id", id));
    }

    //feature 1
    @Override
    public User createUser(User user) {
        //if (tariff <= 0) throw exception
        //if (payment is AUTOMATIC and card is not provided) throw exception
        //if (card is provided)
            //if (card fields have incorrect format) throw exception
            //if (card number already exists) throw ValueNotUniqueException
        User u = userRepository.save(user);
        plannerWebClient.planBillsPaymentForANewUser(u);
        return u;
    }

    //feature 5
    @Override
    public User banUser(Long id) {
        User user = getUserById(id);
        user.setIsBanned(true);
        return userRepository.save(user);
    }

}
