package atividade11_clienteprodutopedido;

import java.util.ArrayList;
import java.util.Scanner;

class Produto {

    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }
}

class Pedido {

    private int numero;
    private Produto produto;
    private int quantidade;

    public Pedido(int numero, Produto produto, int quantidade) {
        this.numero = numero;
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public int getNumero() {
        return numero;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double calcularValorTotal() {
        return this.produto.getPreco() * this.quantidade;
    }
}

class Cliente {

    private String nome;
    private ArrayList<Pedido> listaPedidos;

    public Cliente(String nome) {
        this.nome = nome;
        this.listaPedidos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Pedido> getListaPedidos() {
        return listaPedidos;
    }

    public void adicionarPedido(Pedido p) {
        this.listaPedidos.add(p);
    }
}

public class Main {

    static ArrayList<Cliente> listaClientes = new ArrayList<>();
    static ArrayList<Produto> listaProdutos = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao = 5;

        while (opcao != 0) {
            System.out.println("""
                           digite o numero referente a sua opção:
                           0 -  encerrar o programa.
                           1 -  Adicionar Cliente.
                           2 -  Adicionar Produto ao Catalogo.
                           3 -  Registrar Pedido para um Cliente.
                           4 -  Consultar Pedidos por Cliente.
                           """);

            opcao = Integer.parseInt(input.nextLine());

            switch (opcao) {
                case 1:
                    criarCliente();
                    break;
                case 2:
                    criarProduto();
                    break;
                case 3:
                    cadastrarPedido();
                    break;
                case 4:
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

        Cliente c = new Cliente(nome);
        listaClientes.add(c);
        System.out.println("cliente cadastrado com sucesso !!!");
    }

    public static void criarProduto() {
        System.out.println("digite o nome do produto:");
        String nome = input.nextLine();

        System.out.println("digite o preco unitario do produto:");
        double preco = Double.parseDouble(input.nextLine());

        Produto p = new Produto(nome, preco);
        listaProdutos.add(p);
        System.out.println("produto cadastrado com sucesso !!!");
    }

    public static void cadastrarPedido() {
        if (listaClientes.isEmpty()) {
            System.out.println("nenhum cliente cadastrado, tente outra operacao!!!");
            return;
        }

        if (listaProdutos.isEmpty()) {
            System.out.println("nenhum produto no catalogo, cadastre produtos primeiro!!!");
            return;
        }

        System.out.println("Selecione o cliente:");
        for (int i = 0; i < listaClientes.size(); i++) {
            System.out.println((i + 1) + " - " + listaClientes.get(i).getNome());
        }
        int escCliente = Integer.parseInt(input.nextLine()) - 1;

        if (escCliente < 0 || escCliente >= listaClientes.size()) {
            System.out.println("cliente invalido !!!");
            return;
        }

        System.out.println("Selecione o produto:");
        for (int i = 0; i < listaProdutos.size(); i++) {
            System.out.println((i + 1) + " - " + listaProdutos.get(i).getNome() + " (R$ " + listaProdutos.get(i).getPreco() + ")");
        }
        int escProduto = Integer.parseInt(input.nextLine()) - 1;

        if (escProduto < 0 || escProduto >= listaProdutos.size()) {
            System.out.println("produto invalido !!!");
            return;
        }

        System.out.println("digite o numero do pedido:");
        int numero = Integer.parseInt(input.nextLine());

        System.out.println("digite a quantidade comprada:");
        int qtd = Integer.parseInt(input.nextLine());

        Cliente cliente = listaClientes.get(escCliente);
        Produto produto = listaProdutos.get(escProduto);

        Pedido ped = new Pedido(numero, produto, qtd);
        cliente.adicionarPedido(ped);

        System.out.println("pedido registrado com sucesso! Total: R$ " + ped.calcularValorTotal());
    }

    public static void consultarCliente() {
        if (listaClientes.isEmpty()) {
            System.out.println("nenhum cliente cadastrado, tente outra operacao!!!");
            return;
        }

        System.out.println("Selecione o cliente que deseja consultar:");
        for (int i = 0; i < listaClientes.size(); i++) {
            System.out.println((i + 1) + " - " + listaClientes.get(i).getNome());
        }

        int escolha = Integer.parseInt(input.nextLine()) - 1;

        if (escolha >= 0 && escolha < listaClientes.size()) {
            Cliente cliente = listaClientes.get(escolha);
            ArrayList<Pedido> pedidos = cliente.getListaPedidos();

            System.out.println("Historico de compras do cliente " + cliente.getNome() + ":");
            if (pedidos.isEmpty()) {
                System.out.println("nenhum pedido encontrado para este cliente !!!");
            } else {
                double gastoTotal = 0;
                for (Pedido p : pedidos) {
                    double totalItem = p.calcularValorTotal();
                    gastoTotal += totalItem;
                    System.out.println("- Pedido N° " + p.getNumero() + " | Produto: " + p.getProduto().getNome() + " | Qtd: " + p.getQuantidade() + " | Preco Un: R$ " + p.getProduto().getPreco() + " | Subtotal: R$ " + totalItem);
                }
                System.out.println("Total Geral Acumulado: R$ " + gastoTotal);
            }
        } else {
            System.out.println("digite um valor valido !!!");
        }
    }
}
// precisei fazer a classe pedido (que lembra bastante a entidade associativa de um estruturação de banco de dados, achei interessante mas varias coisas ainda foram semelhante a os outros exercicios