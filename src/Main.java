import DadosUsuario.DadosConta;
import java.util.Scanner;

public class Main extends DadosConta {
    public static void main(String[] args) throws InterruptedException {
        DadosConta contaAllisson = new DadosConta();
        Scanner sc = new Scanner(System.in);
        int escolha = 0;
        System.out.println();
        System.out.println("""
                IIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII
                II                                                            II
                II ==================== BANCO NACIONAL IFAP ================= II
                II                                                            II
                IIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII""");

        System.out.println();
        while (escolha != 5){
            // menu de opções
            System.out.println("""
                [ 1 ] Sacar
                [ 2 ] Depositar
                [ 3 ] transfererir
                [ 4 ] Consultar saldo
                [ 5 ] Encerrar"""); // opções para ser escolhida //
            System.out.println();

            System.out.print("Opção desejada: ");
            escolha = sc.nextInt();

            if(escolha == 1) { // saque //
                System.out.print("Digite o valor do saque: ");
                var saque = sc.nextDouble();
                if (contaAllisson.getSaldo() < saque) {
                    Thread.sleep(300);
                    System.out.println("Saldo insuficiente.");
                    System.out.println();
                    Thread.sleep(1000);
                } else {
                    contaAllisson.setSaldo(contaAllisson.getSaldo() - saque);
                    System.out.println("Saque de : " + saque + " relaizado.");
                    Thread.sleep(100);
                    System.out.println("Novo saldo: " + contaAllisson.getSaldo());
                    Thread.sleep(1000);
                    System.out.println();
                }

            } else if (escolha == 2) { // deposito //
                System.out.print("Digite o valor a ser depositado: ");
                var deposito = sc.nextDouble();
                contaAllisson.setSaldo(contaAllisson.getSaldo() + deposito);
                Thread.sleep(300);
                System.out.println("Deposito de R$" + deposito + " realizado.");
                Thread.sleep(100);
                System.out.println("Novo saldo: " + contaAllisson.getSaldo());

            } else if (escolha == 3) { // transferencia //
                System.out.print("Digite a conta que irá receber a transferencia: ");
                int contaAlvo = sc.nextInt();
                Thread.sleep(150);
                System.out.print("Digite o valor a ser transferido: ");
                double valorTransferencia = sc.nextDouble();
                if (valorTransferencia > contaAllisson.getSaldo()) {
                    System.out.println("Saldo insuficiente.");
                } else {
                    System.out.println("Valor de R$" + valorTransferencia + " transferido para a conta " + contaAlvo +".");
                    Thread.sleep(180);
                    contaAllisson.setSaldo(contaAllisson.getSaldo() - valorTransferencia);
                    System.out.println("Novo saldo: " + contaAllisson.getSaldo());
                    Thread.sleep(200);
                }
            } else if (escolha == 4) { // consultar saldo //
                System.out.println("Saldo atual: " + contaAllisson.getSaldo());
                Thread.sleep(1000);
                System.out.println();

            } else if (escolha == 5 ) {
                    System.out.println("Obrigado(a) por utilizar o nosso banco!" + "\nVolte sempre!");
                    Thread.sleep(1000);

                } else { // encerrar o programa //
                System.out.println("Opção inválida. Escolha novamente.");
                Thread.sleep(1000);
            }
        }
        sc.close();
    }
}