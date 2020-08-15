package com.example.demo.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author yuriismac on 2020-07-15.
 * @project demo
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueCinemaTitleValidator.class)
public @interface UniqueCinemaTitle {

    String message () default "Cinema title should be unique!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
