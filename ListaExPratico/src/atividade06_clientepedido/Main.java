
package atividade06_clientepedido;

import java.util.ArrayList;
import java.util.Scanner;

class Pedido {

    private int numero;
    private double valor;
    private boolean situacao; // true: Pago/Entregue, false: Pendente

    public Pedido(int numero, double valor, boolean situacao) {
        this.numero = numero;
        this.valor = valor;
        this.situacao = situacao;
    }

    public int getNumero() {
        return numero;
    }

    public double getValor() {
        return valor;
    }

    public boolean getSituacao() {
        return situacao;
    }
}

class Cliente {

    private String nomeCliente;
    private ArrayList<Pedido> listaPedidos;

    public Cliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
        this.listaPedidos = new ArrayList<>();
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public ArrayList<Pedido> getListaPedidos() {
        return listaPedidos;
    }

    public void adicionarPedido(Pedido ped) {
        this.listaPedidos.add(ped);
    }
}

public class Main {

    static ArrayList<Cliente> listaClientes = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao = 4;

        while (opcao != 0) {
            System.out.println("""
                           digite o numero referente a sua opção:
                           0 -  encerrar o programa.
                           1 -  Adicionar Cliente.
                           2 -  Adicionar Pedido para um Cliente.
                           3 -  Consultar pedidos por Clientes.
                           """);

            opcao = Integer.parseInt(input.nextLine());

            switch (opcao) {
                case 1:
                    criarCliente();
                    break;
                case 2:
                    cadastrarPedido();
                    break;
                case 3:
                    consultarCliente();
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

    public static void criarCliente() {
        System.out.println("digite o nome do cliente:");
        String nome = input.nextLine();

        Cliente clien = new Cliente(nome);
        listaClientes.add(clien);
        System.out.println("cliente adicionado com sucesso !!!");
    }

    public static void cadastrarPedido() {
        if (listaClientes.isEmpty()) {
            System.out.println("nenhum cliente cadastrado, tente outra operacao!!!");
            return;
        }

        System.out.println("digite o numero do pedido:");
        int numero = Integer.parseInt(input.nextLine());

        System.out.println("digite o valor do pedido:");
        double valor = Double.parseDouble(input.nextLine());

        System.out.println("o pedido esta pago/finalizado? (true/false):");
        boolean situacao = Boolean.parseBoolean(input.nextLine());

        System.out.println("Selecione o numero do cliente deste pedido:");
        for (int i = 0; i < listaClientes.size(); i++) {
            System.out.println((i + 1) + " - " + listaClientes.get(i).getNomeCliente());
        }

        int escolha = Integer.parseInt(input.nextLine()) - 1;

        if (escolha >= 0 && escolha < listaClientes.size()) {
            Pedido ped = new Pedido(numero, valor, situacao);
            listaClientes.get(escolha).adicionarPedido(ped);
            System.out.println("pedido vinculado com sucesso !!!");
        } else {
            System.out.println("digite um valor valido !!!");
        }
    }

    public static void consultarCliente() {
        if (listaClientes.isEmpty()) {
            System.out.println("nenhum cliente cadastrado, tente outra operacao!!!");
            return;
        }

        System.out.println("Selecione o numero do cliente que deseja consultar:");
        for (int i = 0; i < listaClientes.size(); i++) {
            System.out.println((i + 1) + " - " + listaClientes.get(i).getNomeCliente());
        }

        int escolha = Integer.parseInt(input.nextLine()) - 1;

        if (escolha >= 0 && escolha < listaClientes.size()) {
            Cliente clien = listaClientes.get(escolha);
            ArrayList<Pedido> pedidos = clien.getListaPedidos();

            System.out.println("pedidos do cliente " + clien.getNomeCliente() + ":");
            if (pedidos.isEmpty()) {
                System.out.println("nenhum pedido cadastrado para esse cliente !!!");
            } else {
                for (int i = 0; i < pedidos.size(); i++) {
                    Pedido p = pedidos.get(i);
                    String status = p.getSituacao() ? "Pago/Finalizado" : "Pendente";
                    System.out.println("- Pedido N°: " + p.getNumero() + " | Valor: R$ " + p.getValor() + " | Situacao: " + status);
                }
            }
        } else {
            System.out.println("digite um valor valido !!!");
        }
    }
}
