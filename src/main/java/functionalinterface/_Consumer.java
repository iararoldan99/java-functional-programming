package functionalinterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {
    public static void main(String[] args) {
        // una operacion que recibe un argumento y no retorna nada

        var maria = new Costumer("Maria", 181818);

        greetCustomer(maria);

        // consumer usa el metodo accept para recibir el argumento
        greetConsumerConsumer.accept(maria);

        // biconsumer acepta dos argumentos, en este caso un integer y un boolean
        greetConsumerBiConsumer.accept(maria, false);
    }

    //old style
    static void greetCustomer(Costumer costumer){
        System.out.println("Hello " + costumer.name);
    }

    // consumer style

    static Consumer<Costumer> greetConsumerConsumer = costumer ->
        System.out.println("Hello " + costumer.name);

    // biconsumer style
    static BiConsumer<Costumer, Boolean> greetConsumerBiConsumer = (costumer, showPhoneNumber) ->
        System.out.println("Hello " + costumer.name +
                " thanks for registering the phone number "
                + (showPhoneNumber ? costumer.phoneNumber : "*********"));


    static class Costumer{
        private final String name;
        private final Integer phoneNumber;

        public Costumer(String name, Integer phoneNumber) {
            this.name = name;
            this.phoneNumber = phoneNumber;
        }
    }
}
