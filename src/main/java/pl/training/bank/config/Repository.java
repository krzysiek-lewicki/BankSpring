package pl.training.bank.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import pl.training.bank.service.repository.AccountsRepository;
import pl.training.bank.service.repository.MySqlAccountsRepository;

import javax.sql.DataSource;

@EnableTransactionManagement
@PropertySource("classpath:jdbc.properties")
@Configuration
public class Repository {

    @Autowired
    private Environment environment;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUsername(environment.getProperty("database.username"));
        dataSource.setPassword(environment.getProperty("database.password"));
        dataSource.setUrl(environment.getProperty("database.url"));
        dataSource.setDriverClassName(environment.getProperty("database.driver"));
        return dataSource;
    }

    @Bean
    public AccountsRepository accountsRepository(DataSource dataSource) {
        return new MySqlAccountsRepository(dataSource);
    }

    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}
