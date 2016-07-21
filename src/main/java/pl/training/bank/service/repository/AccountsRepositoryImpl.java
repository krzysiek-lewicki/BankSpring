package pl.training.bank.service.repository;

import pl.training.bank.entity.Account;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

public class AccountsRepositoryImpl implements AccountsRepositoryCustom {

    private static final String SELECT_BY_ACCOUNT_NUMBER = "select a from Account a where a.number = :number";

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Account getByNumber(String accountNumber) {
        try {
            return entityManager.createQuery(SELECT_BY_ACCOUNT_NUMBER, Account.class)
                    .setParameter("number", accountNumber)
                    .getSingleResult();
        } catch (NoResultException ex) {
            throw new AccountNotFoundException();
        }
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

}
