package pl.training.bank.operation;

public class TransferOperation extends Operation {

    public TransferOperation() {
    }

    public TransferOperation(String sourceAccountNumber, String destinationAccountNumber, long funds) {
        super(sourceAccountNumber, funds);
        this.destinationAccountNumber = destinationAccountNumber;
    }

    @Override
    public void execute() {
        WithdrawOperation withdrawOperation = new WithdrawOperation(sourceAccountNumber, funds);
        withdrawOperation.setAccountsRepository(accountsRepository);
        withdrawOperation.execute();

        DepositOperation depositOperation = new DepositOperation(destinationAccountNumber, funds);
        depositOperation.setAccountsRepository(accountsRepository);
        depositOperation.execute();
    }

    @Override
    public String toString() {
        return String.format("%s ==> %s ==> %s", sourceAccountNumber, formatCurrency(funds), destinationAccountNumber);
    }

}
