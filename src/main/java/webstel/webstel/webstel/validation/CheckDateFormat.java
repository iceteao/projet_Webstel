package webstel.webstel.webstel.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target ({ElementType.FIELD})
@Retention (RetentionPolicy.RUNTIME)
@Constraint (validatedBy= CheckDateValidator.class)
public @interface CheckDateFormat {

    String message() default "The starting date need to be after today's date";

	
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
    String pattern();

}