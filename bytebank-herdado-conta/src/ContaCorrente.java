public class ContaCorrente extends Conta implements Tributavel {
    CalculadorImposto calculadorImposto;

    public ContaCorrente(int agencia, int numero, CalculadorImposto calculadorImposto) {
        super(agencia, numero);
        this.calculadorImposto = calculadorImposto;
    }

    @Override
    public void deposita(double valor) {
        double saldoAtual = super.getSaldo();
        double novoSaldo = saldoAtual + valor;
        super.setSaldo(novoSaldo);
    }

    @Override
    public void saca(double valor) throws SaldoInsuficienteException {
        double valorASacar = valor + 0.1;
        super.saca(valorASacar);
    }

    @Override
    public double getValorImposto() {
        return this.calculadorImposto.getValorImposto();
    }
}
