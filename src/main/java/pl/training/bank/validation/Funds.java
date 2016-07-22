package pl.training.bank.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = FundsValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Funds {

    long maxValue() default Long.MAX_VALUE;

    String message() default "Invalid funds value";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
