package webstel.webstel.webstel.validation;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckDateValidator implements ConstraintValidator<CheckDateFormat, String> {


	private String pattern;
    LocalDate localDate = LocalDate.now();
	String CurrentDate = localDate.format(DateTimeFormatter.ofPattern("DD/MM/YYYY"));
	
    @Override
    public void initialize(CheckDateFormat constraintAnnotation) {
        this.pattern = constraintAnnotation.pattern();

    }

    
    @Override
    public boolean isValid(String object, ConstraintValidatorContext constraintContext) {
        if ( object == null ) {
            return true;
        }

        try {
            Date date = new SimpleDateFormat(pattern).parse(object);
            Date CDate = new SimpleDateFormat(pattern).parse(CurrentDate);
            if (date.compareTo(CDate)<=0) {
            	return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
        
        
    }
}