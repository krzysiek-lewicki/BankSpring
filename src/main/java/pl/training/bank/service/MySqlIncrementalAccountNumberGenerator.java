package pl.training.bank.service;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class MySqlIncrementalAccountNumberGenerator extends IncrementalAccountNumberGenerator {

    private static final String GET_LAST_ACCOUNT_NUMBER_SQL = "select max(number) from accounts";

    public MySqlIncrementalAccountNumberGenerator(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String lastAccountNumber = jdbcTemplate.queryForObject(GET_LAST_ACCOUNT_NUMBER_SQL, String.class);
        setCounter(lastAccountNumber);
    }

}
