package com.example.paymentService.services.implementations;

import com.example.paymentService.exceptions.RecordNotFoundException;
import com.example.paymentService.models.Bill;
import com.example.paymentService.models.Transaction;
import com.example.paymentService.models.User;
import com.example.paymentService.repositories.BillRepository;
import com.example.paymentService.services.interfaces.BillService;
import com.example.paymentService.services.interfaces.UserService;
import com.example.paymentService.utils.Utils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BillServiceImpl implements BillService {

    private BillRepository billRepository;
    private UserService userService;
    private Utils utils;

    @Override
    public Bill getBillById(Long id) {
        return billRepository
                .findById(id)
                .orElseThrow(() -> new RecordNotFoundException(Bill.class, "id", id));
    }

    @Override
    public Iterable<Bill> getBillsOfUser(Long userId) {
        return billRepository.findAll().stream().filter(
                b -> b.getUser().getId().equals(userId)).collect(Collectors.toList());
    }

    @Override
    public Bill createBillOfUser(Long userId) {
        User user = userService.getUserById(userId);
        utils.checkWhetherUserIsNotBanned(user);
        Bill bill = new Bill(user, user.getTariff(), new Date());
        return billRepository.save(bill);
    }

    @Override
    public Transaction getSuccessfulTransaction(Bill bill) {
        List<Transaction> successfulTransactions =
                bill.getTransactions().stream().filter(Transaction::getIsSuccessful).toList();
        return successfulTransactions.size() > 0 ? successfulTransactions.get(0) : null;
    }

    @Override
    public long getQuantityOfNotPaidBills(User user) {
        return billRepository.findAll().stream().filter(
                b -> (b.getUser().getId().equals(user.getId()) &&
                        getSuccessfulTransaction(b) == null)).count();
    }

}
