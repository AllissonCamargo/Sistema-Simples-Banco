package DadosUsuario;

public class DadosConta {
    private String nomeUsuario = "Allisson";
    private double saldo;

    public String getNome() {
        return nomeUsuario;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
