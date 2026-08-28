package atividade03_Banco;

import java.util.Scanner;

class ContaBancaria {

    private int numero;
    private String titular;
    private double saldo;

    public ContaBancaria(int numero, String titular, double saldo) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
    }

    public int getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
        } else {
            System.out.println("operação negada, voce precisa depositar um saldo positivo!!!");
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= this.saldo) {
            this.saldo -= valor;
        } else if (valor < 0) {
            System.out.println("operação negada, voce precisa sacar um valor posito");
        } else {
            System.out.println("operação negada, voce precisa sacar um valor menor ou igual ao seu saldo!!!");
        }
    }
}

public class Main {

    static ContaBancaria conta1;
    static ContaBancaria conta2;
    static ContaBancaria conta3;
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao = 4, codigo = 0;

        while (opcao != 0) {
            System.out.println("""
                           digite o numero referente a sua opção:
                           0 -  encerrar o programa.
                           1 -  criar uma Conta.
                           2 -  consultar o saldo
                           3 -  realizar operação financeira
                           """);

            opcao = Integer.parseInt(input.nextLine());

            switch (opcao) {
                case 1: {
                    codigo++;
                    criarConta(codigo);
                    break;
                }
                case 2:
                    consultarSaldo();
                    break;
                case 3:
                    realizarOperacao();
                    break;
                case 0:
                    System.out.println("saindo do programa !!!");
                    break;
                default:
                    System.out.println("digite um valor valido !!!");
                    break;
            }
        }
        input.close();
    }

    public static void criarConta(int numero) {
        String titular;
        double saldo;

        if (numero > 3) {
            System.out.println("voce cadastrou o maximo de contas, Voltando ao Menu !!!");
        } else {

            System.out.println("o numero dessa conta é " + numero);

            System.out.println("digite o nome do titular da conta:");
            titular = input.nextLine();

            System.out.println("digite o saldo inicial da conta:");
            saldo = Double.parseDouble(input.nextLine());

            switch (numero) {
                case 1:
                    conta1 = new ContaBancaria(numero, titular, saldo);
                    break;
                case 2:
                    conta2 = new ContaBancaria(numero, titular, saldo);
                    break;
                case 3:
                    conta3 = new ContaBancaria(numero, titular, saldo);
                    break;
            }
        }
    }

    public static void consultarSaldo() {
        ContaBancaria conta = buscarConta();
        if (conta == null) {
            return;
        }
        System.out.println("o saldo da conta de numero: " + conta.getNumero() + " com o titular: "+ conta.getTitular()+"\n esta em: " + conta.getSaldo() + "R$");

    }

    public static void realizarOperacao() {
        int n;
        double valor;
        ContaBancaria conta = buscarConta();
        if (conta == null) {
            return;
        }

        System.out.println(""" 
                           Digite o numero da operação que voce deseja realizar:
                           1 -  deposito
                           2 -  saque
                           digite qualquer outro numero para não fazer nenhuma operação
                           """);
        n = Integer.parseInt(input.nextLine());
        if (n == 1) {
            System.out.println("digite a quantidade de dinheiro que voce deseja depositar: ");
            valor = Double.parseDouble(input.nextLine());
            conta.depositar(valor);

        } else if (n == 2) {
            System.out.println("digite a quantidade de dinheiro que voce deseja sacar: ");
            valor = Double.parseDouble(input.nextLine());
            conta.sacar(valor);
        } else {
            System.out.println("nenhuma operação realizada, voltando ao menu!!!");
        }
    }

    public static ContaBancaria buscarConta() {

        System.out.println("Digite o número da conta que quer acessar");
        int n = Integer.parseInt(input.nextLine());

        switch (n) {
            case 1:
                if (conta1 != null) {
                    return conta1;
                }
                break;

            case 2:
                if (conta2 != null) {
                    return conta2;
                }
                break;

            case 3:
                if (conta3 != null) {
                    return conta3;
                }
                break;
        }

        System.out.println("Conta não encontrada!");
        return null;
    }
}
