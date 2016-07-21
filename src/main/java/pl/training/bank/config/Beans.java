package pl.training.bank.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import pl.training.bank.operation.ConsoleOperationLogger;
import pl.training.bank.service.AccountNumberGenerator;
import pl.training.bank.service.AccountsService;
import pl.training.bank.service.JpaIncrementalAccountNumberGenerator;
import pl.training.bank.service.repository.AccountsRepository;

import javax.persistence.EntityManagerFactory;

@Import(Repository.class)
@EnableAspectJAutoProxy
@Configuration
public class Beans {

    @Bean
    public AccountNumberGenerator accountNumberGenerator(EntityManagerFactory entityManagerFactory) {
        return new JpaIncrementalAccountNumberGenerator(entityManagerFactory);
    }

    //@Scope(BeanDefinition.SCOPE_PROTOTYPE)
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public AccountsService accountsService(AccountsRepository accountsRepository, AccountNumberGenerator accountNumberGenerator) {
        return new AccountsService(accountsRepository, accountNumberGenerator);
    }

    @Bean
    public ConsoleOperationLogger operationLogger() {
        return new ConsoleOperationLogger();
    }

}
