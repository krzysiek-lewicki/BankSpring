package pl.training.bank.operation;

import pl.training.bank.BankException;

public class ConsoleOperationLogger {

    private static final String SEPARATOR = "####################################################################";

    public void beforeOperation(Operation operation) {
        System.out.println(SEPARATOR);
        System.out.println(operation);
    }

    public  void onSuccess(Operation operation) {
        System.out.format("Status: success\n%s\n", SEPARATOR);
    }

    public void onException(Operation operation, BankException ex) {
        System.out.format("Status: exception (%s)\n%s\n", ex.getClass().getSimpleName(), SEPARATOR);
    }

}
