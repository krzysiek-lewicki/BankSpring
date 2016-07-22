package pl.training.bank.service;

import org.springframework.transaction.annotation.Transactional;
import pl.training.bank.entity.Account;
import pl.training.bank.operation.Operation;
import pl.training.bank.service.repository.AccountsRepository;

import java.util.ArrayList;
import java.util.List;

@Transactional
public class AccountsService {

    private AccountsRepository accountsRepository;
    private AccountNumberGenerator accountNumberGenerator;

    public AccountsService(AccountsRepository accountsRepository, AccountNumberGenerator accountNumberGenerator) {
        this.accountsRepository = accountsRepository;
        this.accountNumberGenerator = accountNumberGenerator;
    }

    public Account createAccount() {
        Account account = new Account(accountNumberGenerator.getNext());
        accountsRepository.save(account);
        return account;
    }

    public void process(Operation operation) {
        operation.setAccountsRepository(accountsRepository);
        operation.execute();
    }

    public Account getAccountByNumber(String accountNumber) {
        return accountsRepository.getByNumber(accountNumber);
    }

    public List<Account> getAccounts(int pageNumber, int pageSize) {
        return new ArrayList<>();
    }

    public void init() {
        System.out.println("AccountsService init...");
    }

    public void destroy() {
        System.out.println("AccountsService destroy...");
    }

}
