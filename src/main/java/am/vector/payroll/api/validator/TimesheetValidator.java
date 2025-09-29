package am.vector.payroll.api.validator;

import am.vector.payroll.api.entity.Timesheet;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component("beforeCreateTimesheetValidator")
public class TimesheetValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Timesheet.class.equals(clazz);
    }

    @Override
    public void validate(@Nullable Object o, Errors errors) {
        Timesheet timesheet = (Timesheet) o;
        if(timesheet.getTotal()>168){
            errors.rejectValue("total", "Total cant be more then 168");
        }

    }
}
