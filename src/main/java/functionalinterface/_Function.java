package functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {
        // FUNCTION
        int increment = increment(1);
        System.out.println(increment);

        // apply basically receives the function argument
        int increment2 = incrementByOneFunction.apply(1);
        System.out.println(increment2);

        int multiply = multiplyByTen.apply(increment2);
        System.out.println(multiply);

        //combining with andThen method
        Function<Integer, Integer> addBy1AndThenMultiplyByTen =
                incrementByOneFunction.andThen(multiplyByTen);

        System.out.println(addBy1AndThenMultiplyByTen.apply(5));

        // BIFUNCTION (recibe dos argumentos y devuelve un solo valor)

        System.out.println("old style: " + incrementByOneAndMultiplyBy(4, 100));
        System.out.println("bifunction style: " + incrementByOneAndMultiplyBiFunction.apply(4, 100));//recibe dos argumentos y retorna UNO

    }

    static int increment(int number){
        return number + 1;
    }

    // using Java.util Function<T,R> functional interface
    // accepts an Integer as an argument and returns also an Integer
    static Function<Integer, Integer> incrementByOneFunction = number -> number +1;
    static Function<Integer, Integer> multiplyByTen = number -> number * 10;

    //using bifunction
    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBiFunction =
            (numberToIncrementByOne, numToMultiplyBy)
                    -> (numberToIncrementByOne + 1) * numToMultiplyBy;
    //old style
    static int incrementByOneAndMultiplyBy(int number, int multiplyBy){
        return (number + 1) * multiplyBy;
    }
}
