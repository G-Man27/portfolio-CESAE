package Ex_02;

public class Conta {
    private String n_conta = "000000000";
    private String titular;
    private double saldo = 0;
    private int ano_abertura = 2023;
    private double margem = 0.9 * saldo;
    private double divida = 0;

    private String Conta(int n_conta) {
        this.n_conta= Integer.toString(n_conta);
        while (this.n_conta.length()<9) {
            this.n_conta="0"+this.n_conta;
        }
        return this.n_conta;
    }

    public Conta(int n_conta, String titular, double saldo) {
        this.n_conta=Conta(n_conta);
        this.titular = titular;
        this.saldo = saldo;
    }

    public Conta(int n_conta, String titular) {
        this.n_conta = Conta(n_conta);
        this.titular = titular;
    }

    public String getN_conta() {
        return n_conta;
    }

    public void depositar(double valor) {
        System.out.println("Depósito Efetuado: " + valor);
        this.saldo += valor;
        this.setMargem();
    }

    public void levantar(double valor) {
        if (this.saldo >= valor) {
            System.out.println("Levantamento Efetuado: " + valor);
            this.saldo -= valor;
            this.setMargem();
        } else {
            System.out.println("Levantamento Recusado. Saldo Insuficiente.");
        }
    }

    public void transferir(double valor, Conta contaDestino) {
        if (this.saldo >= valor) {
            System.out.println("Transferencia Efetuada: " + valor);
            this.saldo -= valor;
            contaDestino.saldo += valor;

            this.setMargem();
            contaDestino.setMargem();
        } else {
            System.out.println("Transferência Recusada. Saldo Insuficiente.");
        }
    }

    public double getMargem() {
        return this.margem;
    }

    public void setMargem() {
        this.margem=0.9*this.saldo;
    }

    public boolean pedirEmprestimo(int valor){
        if(this.divida>0){
            System.out.println("Tem uma dívida pendente.");
            return false;
        }else {
            if (valor > this.margem){
                System.out.println("O valor que pediu ultrapassa a sua margem.");
                return false;
            }else {
                this.depositar(valor);
                this.setMargem();
                this.divida+=valor;
                return true;
            }
        }
    }

    public void exibirDetalhes() {
        System.out.println("Numero Conta: " + this.n_conta + "\t| Titular: " + this.titular + "\t| Saldo: " + this.saldo + " €"+ "\t| Margem: " + this.margem + "\t| Dívida: " + this.divida + " €");
    }
}
