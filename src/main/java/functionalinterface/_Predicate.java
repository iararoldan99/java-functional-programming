package functionalinterface;

import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args) {
        System.out.println("without predicate:");
        System.out.println(isPhoneNumberValid("07111111111"));
        System.out.println(isPhoneNumberValid("09111111111"));
        System.out.println("with predicate:");
        System.out.println(isPhoneNumberValidPredicate.test("07111111111")); // Predicate usa el metodo test para aceptar el argumento
        System.out.println(isPhoneNumberValidPredicate.test("09111111111"));

        // COMBINANDO PREDICATES
        // usamos el primer predicate y lo encadenamos al segundo con el metodo and(), y finalmente con test() le pasamos el argumento a validar
        // Al usar AND es como si usaramos && es decir que ambos predicates deben ser verdaderos para que devuelva true
        System.out.println("Usando and():");
        System.out.println("Is phone num valid and contains num 3: " + isPhoneNumberValidPredicate.and(containsNumber3).test("07111111111"));
        System.out.println("Is phone num valid and contains num 3: " + isPhoneNumberValidPredicate.and(containsNumber3).test("09111111111"));
        System.out.println("Is phone num valid and contains num 3: " + isPhoneNumberValidPredicate.and(containsNumber3).test("07311111111"));

        // COMBINANDO PREDICATES
        // usando OR() es equivalente a usar || y solo basta con que una condicion sea verdadera
        System.out.println("Usando or():");
        System.out.println("Is phone num valid OR contains num 3: " + isPhoneNumberValidPredicate.or(containsNumber3).test("07111111111"));
        System.out.println("Is phone num valid OR contains num 3: " + isPhoneNumberValidPredicate.or(containsNumber3).test("09111111111"));
        System.out.println("Is phone num valid OR contains num 3: " + isPhoneNumberValidPredicate.or(containsNumber3).test("09131111111"));

    }

    // old style
    static boolean isPhoneNumberValid(String number){
        return number.startsWith("07") && number.length() == 11;
    }

    // Predicate recibe un String y devuelve true o false, guarda una operacion booleana
    static Predicate<String> isPhoneNumberValidPredicate = number ->
            number.startsWith("07") && number.length() == 11;

    static Predicate<String> containsNumber3 = phoneNumber ->
            phoneNumber.contains("3");
}
