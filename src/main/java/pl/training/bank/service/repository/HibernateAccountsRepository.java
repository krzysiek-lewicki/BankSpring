package pl.training.bank.service.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pl.training.bank.entity.Account;

public class HibernateAccountsRepository implements AccountsRepository {

    private static final String SELECT_BY_NUMBER_HQL = "select a from Account a where a.number = :number";

    private SessionFactory sessionFactory;

    public HibernateAccountsRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Account save(Account account) {
        Session session = sessionFactory.getCurrentSession();
        session.save(account);
        session.flush();
        session.refresh(account);
        return account;
    }

    @Override
    public Account getByNumber(String sourceAccountNumber) {
        Account account = (Account) sessionFactory.getCurrentSession()
                .createQuery(SELECT_BY_NUMBER_HQL)
                .setParameter("number", sourceAccountNumber)
                .uniqueResult();
        if (account == null) {
            throw new AccountNotFoundException();
        }
        return account;
    }

    @Override
    public void update(Account account) {
        getByNumber(account.getNumber());
        sessionFactory.getCurrentSession().update(account);
    }

}
