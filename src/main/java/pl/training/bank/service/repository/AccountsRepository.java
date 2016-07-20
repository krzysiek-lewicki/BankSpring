package pl.training.bank.service.repository;

import pl.training.bank.entity.Account;

public interface AccountsRepository {

    Account save(Account account);

    Account getByNumber(String sourceAccountNumber);

    void update(Account account);

}
