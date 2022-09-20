package streams;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static streams.Gender.*;

public class _Sort {
    public static List<Person> getPeople(){
        return List.of(
                new Person("James", 20, MALE),
                new Person("Anna", 18, FEMALE),
                new Person("Pam", 25, NON_BINARY),
                new Person("Elliot", 30, MALE),
                new Person("Vicky", 23, FEMALE)
        );
    }
    List<Person> people = getPeople();

    // sort by age from younger to older
    // sorted recibe un Comparator que llama al metodo comparing y ahi dentro se le pasa el campo por el cual vamos a sortear la lista, en este caso la edad
    List<Person> sortedByAge = people.stream() // comienza el stream de la lista "people"
            .sorted(Comparator.comparing(Person::getAge)) // sorted devuelve otro stream, es una operacion intermedia que va encadenando los streams
            .collect(Collectors.toList()); // operacion terminal, se transforma en una lista

    // sort by age from older to younger usando el metodo reversed()

    List<Person> olderToYounger = people.stream().sorted(Comparator.comparing(Person::getAge).reversed()).collect(Collectors.toList());


}
