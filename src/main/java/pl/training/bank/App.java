package pl.training.bank;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.training.bank.entity.Account;
import pl.training.bank.operation.DepositOperation;
import pl.training.bank.operation.TransferOperation;
import pl.training.bank.operation.WithdrawOperation;
import pl.training.bank.service.AccountsService;

public class App {

    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml")) {
            AccountsService accountsService = applicationContext.getBean(AccountsService.class);

            Account firstAccount = accountsService.createAccount();
            Account secondAccount = accountsService.createAccount();

            accountsService.process(new DepositOperation(firstAccount.getNumber(), 1000));
            accountsService.process(new DepositOperation(secondAccount.getNumber(), 500));
            accountsService.process(new WithdrawOperation(firstAccount.getNumber(), 200));
            accountsService.process(new TransferOperation(firstAccount.getNumber(), secondAccount.getNumber(), 10));

            System.out.println(firstAccount);
            System.out.println(secondAccount);
        }
    }

}