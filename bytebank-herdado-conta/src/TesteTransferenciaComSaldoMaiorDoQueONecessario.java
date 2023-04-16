import java.util.Arrays;
import java.util.List;

public class TesteTransferenciaComSaldoMaiorDoQueONecessario {
    public static void main(String[] args) {
        // preparacao
        TestHelper testHelper = new TestHelper();
        CalculadorImposto calculadorImposto = new CalculadorImposto();
        ContaCorrente cc = new ContaCorrente(-1, -1, calculadorImposto);
        ContaPoupanca cp = new ContaPoupanca(-1, -1);

        // acao
        try {
            cc.transfere(10, cp);
        } catch (SaldoInsuficienteException exception) {
            System.out.println(exception.getMessage());
        }

        // verificacao
        boolean testeSaldoDaContaQueTransferiuSaldo = cc.getSaldo() == 89.9;
        boolean testeSaldoDaContaQueRecebeuSaldo = cp.getSaldo() == 110;
        List<Boolean> testes = Arrays.asList(testeSaldoDaContaQueTransferiuSaldo, testeSaldoDaContaQueRecebeuSaldo);
        testHelper.isAlgumTesteFalhou(testes);
    }
}
