package pl.training.bank.viewmodel;

import pl.training.bank.validation.Funds;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class OperationModel {

    private String name;
    @Pattern(regexp = "\\d{26}")
    @NotNull
    private String sourceAccountNumber = "00000000000000000000000001";
    private String destinationAccountNumber;
    @Funds(maxValue = 2000)
    private long funds;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

}
