package combinatorPattern;

import java.time.LocalDate;

import static combinatorPattern.UserRegistrationValidator.*;
import static combinatorPattern.UserRegistrationValidator.ValidationResult.*;

public class Main {
    public static void main(String[] args) {
        var alice = new User(
                "Alice",
                "0111282821",
                "alicwe@yahoo.com",
                LocalDate.of(1999, 1, 12));

        var service = new UserValidatorService();
        System.out.println(service.isValid(alice));

        // using combinator pattern

        ValidationResult result = isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAdult())
                .apply(alice);

        System.out.println(result);

        if(result != SUCCESS){
            throw new IllegalStateException(result.name());
        }
    }
}
