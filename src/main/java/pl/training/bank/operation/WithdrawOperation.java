package pl.training.bank.operation;

import pl.training.bank.entity.Account;

public class WithdrawOperation extends Operation {

    public WithdrawOperation(String sourceAccountNumber, long funds) {
        super(sourceAccountNumber, funds);
    }

    @Override
    public void execute() {
        Account account = accountsRepository.getByNumber(sourceAccountNumber);
        throwExceptionWhenNoSufficientFunds(account, funds);
        account.withdraw(funds);
        accountsRepository.save(account);
    }

    private void throwExceptionWhenNoSufficientFunds(Account account, long funds) {
        if (account.getBalance() < funds) {
            throw new InsufficientFundsException();
        }
    }

    @Override
    public String toString() {
        return String.format("%s ==> %s", sourceAccountNumber, formatCurrency(funds));
    }

}
