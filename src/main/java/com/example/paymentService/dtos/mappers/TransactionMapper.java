package com.example.paymentService.dtos.mappers;
import com.example.paymentService.dtos.transactions.TransactionGetDto;
import com.example.paymentService.models.Transaction;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

    Iterable<TransactionGetDto> transactionsToTransactionsGetDto(Iterable<Transaction> transactions);
    TransactionGetDto transactionToTransactionGetDto(Transaction transaction);

}
