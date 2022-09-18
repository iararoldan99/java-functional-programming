package combinatorPattern;

import java.time.LocalDate;
import java.time.Period;

public class UserValidatorService {

    // Old normal Style
    private boolean isEmailValid(String email){
        return email.contains("@");
    }

    private boolean isPhoneValid(String num){
        return num.startsWith("011");
    }

    private boolean isAdult(LocalDate dob){
        return Period.between(dob, LocalDate.now()).getYears() > 18;
    }

    public boolean isValid(User user){
        return isEmailValid(user.getEmail()) && isAdult(user.getDob()) && isPhoneValid(user.getPhoneNumber());
    }
}
