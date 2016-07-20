package pl.training.bank.service.repository;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import pl.training.bank.entity.Account;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class AccountExtractor implements ResultSetExtractor<Optional<Account>> {

    @Override
    public Optional<Account> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        if (resultSet.next()) {
            Account account = new Account(resultSet.getString("number"));
            account.setId(resultSet.getLong("id"));
            account.setBalance(resultSet.getLong("balance"));
            return Optional.of(account);
        }
        return Optional.empty();
    }

}
