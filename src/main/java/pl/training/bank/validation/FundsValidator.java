package pl.training.bank.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FundsValidator implements ConstraintValidator<Funds, Long> {

    private long maxValue;

    @Override
    public void initialize(Funds constraintAnnotation) {
        maxValue = constraintAnnotation.maxValue();
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        if (value == null || value > maxValue || value <= 0) {
            return false;
        }
        return true;
    }

}
