package streams;

import imperative.Main;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static streams._Stream.Gender.*;

public class _Stream {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", MALE),
                new Person("Maria", FEMALE),
                new Person("Luna", FEMALE),
                new Person("Bella", FEMALE),
                new Person("Bob", UNICORN)
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

        Predicate<Person> femalePredicate = person -> FEMALE.equals(person.gender
        );

        boolean containsOnlyFemales = people.stream()
                .allMatch(femalePredicate);

        boolean containsAnyFemales = people.stream()
                .anyMatch(femalePredicate);

        System.out.println(containsOnlyFemales);
        System.out.println(containsAnyFemales);

    }

    static class Person {
        private final String name;
        private final Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
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
