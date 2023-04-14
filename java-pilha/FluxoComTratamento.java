import java.util.Arrays;
import java.util.stream.Collectors;

public class FluxoComTratamento {
    public static void main(String[] args) {
        System.out.println("Início do main");

        try {
            metodo1();
        } catch (ArithmeticException | NullPointerException | MinhaException exception) {
            System.out.println("Exceção capturada | " + exception.getMessage() + " | " + Arrays.stream(exception.getStackTrace()).collect(Collectors.toList()));
        }

        System.out.println("Fim do main");
    }

    private static void metodo1() {
        System.out.println("Início do metodo1");

        metodo2();

        System.out.println("Fim do metodo1");
    }

    private static void metodo2() {
        System.out.println("Início do metodo2");

        throw new MinhaException("Deu errado");
    }
}