package combinatorPattern;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

public interface UserRegistrationValidator extends Function<User, UserRegistrationValidator.ValidationResult> {

    // combinator pattern allows us to chain functions together

    static UserRegistrationValidator isEmailValid(){
        return user -> user.getEmail().contains("@") ? ValidationResult.SUCCESS : ValidationResult.EMAIL_NOT_VALID;
    }

    static UserRegistrationValidator isPhoneNumberValid(){
        return user -> user.getPhoneNumber().startsWith("011") ? ValidationResult.SUCCESS : ValidationResult.PHONE_NUM_NOT_VALID;
    }
    static UserRegistrationValidator isAdult(){
        return user -> Period.between(user.getDob(), LocalDate.now()).getYears() > 18 ? ValidationResult.SUCCESS : ValidationResult.NOT_AN_ADULT;
    }

    default UserRegistrationValidator and(UserRegistrationValidator other){
        return user -> {
            ValidationResult result = this.apply(user);
            return result.equals(ValidationResult.SUCCESS) ? other.apply(user) : result;
        };
    }
    enum ValidationResult {
        SUCCESS,
        PHONE_NUM_NOT_VALID,
        NOT_AN_ADULT,
        EMAIL_NOT_VALID
    }
}
