import java.util.Arrays;
import java.util.List;

public class TesteTransferenciaComSaldoExatamenteSuficiente {
    public static void main(String[] args) {
        // preparacao
        TestHelper testHelper = new TestHelper();
        CalculadorImposto calculadorImposto = new CalculadorImposto();
        ContaCorrente contaCorrente = new ContaCorrente(-1, -1, calculadorImposto);
        ContaPoupanca contaPoupanca = new ContaPoupanca(-1, -1);

        // acao
        try {
            contaCorrente.transfere(99.9, contaPoupanca);
        } catch (SaldoInsuficienteException exception) {
            System.out.println(exception.getMessage());
        }

        // verificacao
        boolean testeSaldoDaContaQueTransferiuSaldo = contaCorrente.getSaldo() == 0;
        boolean testeSaldoDaContaQueRecebeuSaldo = contaPoupanca.getSaldo() == 199.9;
        List<Boolean> testes = Arrays.asList(testeSaldoDaContaQueTransferiuSaldo, testeSaldoDaContaQueRecebeuSaldo);
        testHelper.isAlgumTesteFalhou(testes);
    }
}
