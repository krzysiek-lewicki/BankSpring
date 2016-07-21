package pl.training.bank.service.repository;

import pl.training.bank.entity.Account;

public class HibernateAccountsRepository implements AccountsRepository {

    @Override
    public Account save(Account account) {
        return null;
    }

    @Override
    public Account getByNumber(String sourceAccountNumber) {
        return null;
    }

    @Override
    public void update(Account account) {

    }

}
