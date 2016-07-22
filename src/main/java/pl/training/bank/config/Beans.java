package pl.training.bank.config;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.*;
import pl.training.bank.operation.*;
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

    @Bean
    public OperationResolver operationResolver() {
        return new OperationResolver();
    }

    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    @Bean
    public DepositOperation depositOperation() {
        return new DepositOperation();
    }

    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    @Bean
    public WithdrawOperation withdrawOperation() {
        return new WithdrawOperation();
    }

    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    @Bean
    public TransferOperation transferOperation() {
        return new TransferOperation();
    }

}
