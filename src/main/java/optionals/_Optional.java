package optionals;

import java.util.Optional;

public class _Optional {
    public static void main(String[] args) {
        Object o = Optional.ofNullable(null)
                .orElseGet(() -> "default value!");

        Object d = Optional.ofNullable("Chao")
                        .orElseThrow(() -> new IllegalStateException("Error!"));

        Optional.ofNullable("Hello")
                        .ifPresent(System.out::println);

        Optional.ofNullable("iararroldan@gmail.com")
                        .ifPresentOrElse(email -> System.out.println("Sending email to " + email), () -> System.out.println("cannot send email"));

        System.out.println(o);
        System.out.println(d);
    }
}
