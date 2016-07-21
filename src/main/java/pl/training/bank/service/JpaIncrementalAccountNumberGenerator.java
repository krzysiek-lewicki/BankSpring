package pl.training.bank.service;

import javax.persistence.EntityManagerFactory;

public class JpaIncrementalAccountNumberGenerator extends IncrementalAccountNumberGenerator {

    private static final String SELECT_LAST_ACCOUNT_NUMBER_HQL = "select max(a.number) from Account a";

    public JpaIncrementalAccountNumberGenerator(EntityManagerFactory entityManagerFactory) {
        String lastAccountNumber = entityManagerFactory.createEntityManager()
                .createQuery(SELECT_LAST_ACCOUNT_NUMBER_HQL, String.class)
                .getSingleResult();
        setCounter(lastAccountNumber);
    }

}
