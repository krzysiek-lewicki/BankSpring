package pl.training.bank.service.repository;

import pl.training.bank.entity.Account;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

public class JpaAccountsRepository implements AccountsRepository {

    private static final String SELECT_BY_NUMBER_HQL = "select a from Account a where a.number = :number";

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Account save(Account account) {
        entityManager.persist(account);
        entityManager.flush();
        entityManager.refresh(account);
        return account;
    }

    @Override
    public Account getByNumber(String sourceAccountNumber) {
        try {
            return entityManager
                    .createQuery(SELECT_BY_NUMBER_HQL, Account.class)
                    .setParameter("number", sourceAccountNumber)
                    .getSingleResult();
        } catch (NoResultException ex) {
            throw new AccountNotFoundException();
        }
    }

    @Override
    public void update(Account account) {
        entityManager.lock(account, LockModeType.PESSIMISTIC_WRITE);
        getByNumber(account.getNumber());
        entityManager.merge(account);
        entityManager.lock(account, LockModeType.NONE);
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

}
