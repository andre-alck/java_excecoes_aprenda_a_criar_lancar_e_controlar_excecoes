import java.util.Arrays;
import java.util.List;

public class TesteTransferenciaComSaldoMenorDoQueONecessario {
    public static void main(String[] args) {
        // cenario
        TestHelper testHelper = new TestHelper();
        CalculadorImposto calculadorImposto = new CalculadorImposto();
        ContaCorrente cc = new ContaCorrente(-1, -1, calculadorImposto);
        ContaPoupanca cp = new ContaPoupanca(-1, -1);

        // acao
        try {
            cc.transfere(200, cp);
        } catch (SaldoInsuficienteException exception) {
            System.out.println(exception.getMessage());
        }


        // verificacao
        boolean testeSaldoDaContaQueTentouRealizarTransferencia = cc.getSaldo() == 100;
        boolean testeSaldoDaContaQueReceberiaTransferencia = cp.getSaldo() == 100;
        List<Boolean> testes = Arrays.asList(testeSaldoDaContaQueTentouRealizarTransferencia, testeSaldoDaContaQueReceberiaTransferencia);
        testHelper.isAlgumTesteFalhou(testes);
    }
}
