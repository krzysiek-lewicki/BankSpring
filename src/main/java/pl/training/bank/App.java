package pl.training.bank;

import pl.training.bank.entity.Account;
import pl.training.bank.operation.DepositOperation;
import pl.training.bank.operation.TransferOperation;
import pl.training.bank.operation.WithdrawOperation;
import pl.training.bank.service.AccountNumberGenerator;
import pl.training.bank.service.AccountsService;
import pl.training.bank.service.IncrementalAccountNumberGenerator;
import pl.training.bank.service.repository.AccountsRepository;
import pl.training.bank.service.repository.HashMapAccountsRepository;

public class App {

    public static void main(String[] args) {
        AccountNumberGenerator accountNumberGenerator = new IncrementalAccountNumberGenerator();
        AccountsRepository accountsRepository = new HashMapAccountsRepository();
        AccountsService accountsService = new AccountsService(accountsRepository, accountNumberGenerator);

        Account firstAccount = accountsService.createAccount();
        Account secondAccount = accountsService.createAccount();

        accountsService.process(new DepositOperation(firstAccount.getNumber(), 1000));
        accountsService.process(new DepositOperation(secondAccount.getNumber(), 500));
        accountsService.process(new WithdrawOperation(firstAccount.getNumber(), 200));
        accountsService.process(new TransferOperation(firstAccount.getNumber(), secondAccount.getNumber(), 10));

        System.out.println(firstAccount);
        System.out.println(secondAccount);
    }

}