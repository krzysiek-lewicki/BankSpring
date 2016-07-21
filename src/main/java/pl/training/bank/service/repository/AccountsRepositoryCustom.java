package pl.training.bank.service.repository;

import pl.training.bank.entity.Account;

public interface AccountsRepositoryCustom {

    Account getByNumber(String accountNumber);

}
