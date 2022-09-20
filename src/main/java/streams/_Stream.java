package streams;

import imperative.Main;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static streams._Stream.Gender.*;

public class _Stream {
    public static void main(String[] args) {

        // map(), mapToInt(), allMatch(), anyMatch(), noneMatch(), max(), min(), group()

        List<Person> people = List.of(
                new Person("John", 23, MALE),
                new Person("Maria", 17, FEMALE),
                new Person("Luna", 5, FEMALE),
                new Person("Bella", 80, FEMALE),
                new Person("Bob", 15, UNICORN)
        );

        // Approach con stream map() y method reference :: para obtener el genero en una lista

        people.stream().map(person -> person.gender)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        people.stream().map(person -> person.name)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        people.stream().map(person -> person.name)
                .mapToInt(String::length)
                .forEach(System.out::println);

        // All Match, Any Match, None Match retornan true o false

        // Approach con ALL MATCH

        Predicate<Person> femalePredicate = person -> FEMALE.equals(person.gender
        );

        boolean containsOnlyFemales = people.stream()
                .allMatch(femalePredicate);

        // Approach con ANY MATCH

        boolean containsAnyFemales = people.stream()
                .anyMatch(femalePredicate);

        boolean notContainsAnabellas = people.stream().noneMatch(n -> n.name.equalsIgnoreCase("Anabella")); // retorna true porque no hay ningun match
        // si hubiera alguna persona llamada Anabella, daria false

        boolean notContainsBob = people.stream().noneMatch(n -> n.name.equalsIgnoreCase("Bob")); // retorna false ya que SI hay un bob

        System.out.println(containsOnlyFemales);
        System.out.println(containsAnyFemales);
        System.out.println(notContainsAnabellas);
        System.out.println(notContainsBob);

        // Approach con MAX (max value within a collection)

        // Por ejemplo para encontrar la persona con la maxima edad
        // Se utiliza Comparator.comparing() y dentro va lo que queremos comparar, en este caso la edad de la persona
        // si extraemos a una variable, será de tipo Optional ya que puede suceder que no exista
        people.stream().max(Comparator.comparing(person -> person.age))
                .ifPresent(person -> {
                    System.out.println(person); // nos devuelve la persona mas vieja de la lista
                });

        // Approach con MIN (min value within a collection)

        people.stream().min(Comparator.comparing(person -> person.age))
                .ifPresent(person -> {
                    System.out.println(person); // nos devuelve la persona mas JOVEN de la lista
                });

        // Approach con GROUP (agrupar informacion)
        // Si extraemos a una variable, es de tipo Map y la llave (key) sera el genero y devuelve una lista de Personas agrupadas por genero
        // utilizando Collectors.groupingBy()
        Map<Gender, List<Person>> groupByGender = people.stream()
                .collect(Collectors.groupingBy(person -> person.gender));

        groupByGender.forEach((gender, people1) -> {
            System.out.println(gender); // genero
            people1.forEach(System.out::println); // cada persona de la lista agrupada por genero
            System.out.println();
        });
    }

    static class Person {
        private final String name;
        private final Gender gender;
        private final Integer age;

        public Person(String name, Integer age, Gender gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender {
        MALE, FEMALE, UNICORN
    }
}
