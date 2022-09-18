package functionalinterface;

import java.util.List;
import java.util.function.Supplier;

public class _Supplier {
    public static void main(String[] args) {
        // Un Supplier devuelve un valor sin recibir ningun argumento
        // se usa el metodo get() para que retorne el valor
        System.out.println(getDBUrlSupplier.get());
        System.out.println(getListSupplier.get());

    }

    // Ejemplo de funcion que devuelve la URL de una base de datos
    static String getDBUrl(){
        return "jdbc://localhost:5432/users";
    }

    // Supplier<String> devuelve un String pero puede ser cualquier tipo de return type
    static Supplier<String> getDBUrlSupplier =  () -> "jdbc://localhost:5432/users";

    static Supplier<List<String>> getListSupplier =  () -> List.of("Maria", "Ana");

}
