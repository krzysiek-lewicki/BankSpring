package pl.training.bank.operation;

import org.springframework.transaction.annotation.Transactional;
import pl.training.bank.service.repository.AccountsRepository;

import java.text.NumberFormat;

@Transactional
public abstract class Operation {

    protected AccountsRepository accountsRepository;
    protected String sourceAccountNumber;
    protected String destinationAccountNumber;
    protected long funds;

    public Operation() {
    }

    public Operation(String sourceAccountNumber, long funds) {
        this.sourceAccountNumber = sourceAccountNumber;
        this.funds = funds;
    }

    public String getSourceAccountNumber() {
        return sourceAccountNumber;
    }

    public void setSourceAccountNumber(String sourceAccountNumber) {
        this.sourceAccountNumber = sourceAccountNumber;
    }

    public String getDestinationAccountNumber() {
        return destinationAccountNumber;
    }

    public void setDestinationAccountNumber(String destinationAccountNumber) {
        this.destinationAccountNumber = destinationAccountNumber;
    }

    public long getFunds() {
        return funds;
    }

    public void setFunds(long funds) {
        this.funds = funds;
    }

    public void setAccountsRepository(AccountsRepository accountsRepository) {
        this.accountsRepository = accountsRepository;
    }

    public abstract void execute();

    protected String formatCurrency(long value) {
        return NumberFormat.getCurrencyInstance().format((double) value / 100);
    }

}
