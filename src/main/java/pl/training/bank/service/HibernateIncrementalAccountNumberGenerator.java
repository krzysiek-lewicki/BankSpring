package pl.training.bank.service;

import org.hibernate.SessionFactory;

public class HibernateIncrementalAccountNumberGenerator extends IncrementalAccountNumberGenerator {

    private static final String SELECT_LAST_ACCOUNT_NUMBER_HQL = "select max(a.number) from Account a";

    public HibernateIncrementalAccountNumberGenerator(SessionFactory sessionFactory) {
        String lastAccountNumber = (String) sessionFactory.openSession()
                .createQuery(SELECT_LAST_ACCOUNT_NUMBER_HQL)
                .uniqueResult();
        setCounter(lastAccountNumber);
    }

}
