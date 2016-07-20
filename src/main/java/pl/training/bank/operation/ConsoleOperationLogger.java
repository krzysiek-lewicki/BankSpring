package pl.training.bank.operation;

import org.aspectj.lang.annotation.*;
import pl.training.bank.BankException;

@Aspect
public class ConsoleOperationLogger {

    private static final String SEPARATOR = "####################################################################";

    @Pointcut("execution(void pl.training.bank.service.AccountsService.process(..)) && args(operation)")
    public void processOperation(Operation operation) {
    }

    @Before("processOperation(operation)")
    public void beforeOperation(Operation operation) {
        System.out.println(SEPARATOR);
        System.out.println(operation);
    }

    @AfterReturning("processOperation(operation)")
    public  void onSuccess(Operation operation) {
        System.out.format("Status: success\n%s\n", SEPARATOR);
    }

    @AfterThrowing(value = "processOperation(operation)", throwing = "ex")
    public void onException(Operation operation, BankException ex) {
        System.out.format("Status: exception (%s)\n%s\n", ex.getClass().getSimpleName(), SEPARATOR);
    }

}
