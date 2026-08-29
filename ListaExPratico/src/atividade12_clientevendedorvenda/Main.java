package atividade12_clientevendedorvenda;

import java.util.ArrayList;
import java.util.Scanner;

class Cliente {

    private String nome;
    private ArrayList<Venda> listaVendas;

    public Cliente(String nome) {
        this.nome = nome;
        this.listaVendas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Venda> getListaVendas() {
        return listaVendas;
    }

    public void adicionarVenda(Venda v) {
        this.listaVendas.add(v);
    }

    public double calcularTotalGasto() {
        double total = 0;
        for (Venda v : listaVendas) {
            total += v.getValor();
        }
        return total;
    }
}

class Vendedor {

    private String nome;
    private double percentualComissao;
    private ArrayList<Venda> listaVendas;

    public Vendedor(String nome, double percentualComissao) {
        this.nome = nome;
        this.percentualComissao = percentualComissao;
        this.listaVendas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public double getPercentualComissao() {
        return percentualComissao;
    }

    public ArrayList<Venda> getListaVendas() {
        return listaVendas;
    }

    public void adicionarVenda(Venda v) {
        this.listaVendas.add(v);
    }

    public double calcularTotalComissoes() {
        double total = 0;
        for (Venda v : listaVendas) {
            total += v.calcularValorComissao();
        }
        return total;
    }
}

class Venda {

    private int id;
    private double valor;
    private Cliente cliente;
    private Vendedor vendedor;

    public Venda(int id, double valor, Cliente cliente, Vendedor vendedor) {
        this.id = id;
        this.valor = valor;
        this.cliente = cliente;
        this.vendedor = vendedor;
    }

    public int getId() {
        return id;
    }

    public double getValor() {
        return valor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public double calcularValorComissao() {
        return this.valor * (this.vendedor.getPercentualComissao() / 100.0);
    }

    public void exibeResumo() {
        System.out.println("RESUMO DA VENDA #" + id );
        System.out.println("Cliente comprador: " + cliente.getNome());
        System.out.println("Vendedor responsavel: " + vendedor.getNome());
        System.out.println("Valor da venda: R$ " + valor);
        System.out.println("Comissao dessa venda (" + vendedor.getPercentualComissao() + "%): R$ " + calcularValorComissao());
    }
}

public class Main {

    static ArrayList<Cliente> listaClientes = new ArrayList<>();
    static ArrayList<Vendedor> listaVendedores = new ArrayList<>();
    static ArrayList<Venda> listaVendas = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao = 5;

        while (opcao != 0) {
            System.out.println("""
                           digite o numero referente a sua opçao:
                           0 -  encerrar o programa.
                           1 -  Cadastrar Cliente.
                           2 -  Cadastrar Vendedor.
                           3 -  Registrar Venda.
                           4 -  Exibir Resumo das Vendas.
                           """);

            opcao = Integer.parseInt(input.nextLine());

            switch (opcao) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    cadastrarVendedor();
                    break;
                case 3:
                    registrarVenda();
                    break;
                case 4:
                    exibirResumoVendas();
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

    public static void cadastrarCliente() {
        System.out.println("digite o nome do cliente:");
        String nome = input.nextLine();

        Cliente c = new Cliente(nome);
        listaClientes.add(c);
        System.out.println("cliente cadastrado com suceso !!!");
    }

    public static void cadastrarVendedor() {
        System.out.println("digite o nome do vendedor:");
        String nome = input.nextLine();

        System.out.println("digite a porcentagem de comiçao do vendedor:");
        double comissao = Double.parseDouble(input.nextLine());

        Vendedor v = new Vendedor(nome, comissao);
        listaVendedores.add(v);
        System.out.println("vendedor cadastrado com suceso !!!");
    }

    public static void registrarVenda() {
        if (listaClientes.isEmpty()) {
            System.out.println("nenhum cliente cadastrado, tente outra operacao!!!");
            return;
        }

        if (listaVendedores.isEmpty()) {
            System.out.println("nenhum vendedor cadastrado, tente outra operacao!!!");
            return;
        }

        System.out.println("Selecione o numero do cliente:");
        for (int i = 0; i < listaClientes.size(); i++) {
            System.out.println((i + 1) + " - " + listaClientes.get(i).getNome());
        }
        int escCliente = Integer.parseInt(input.nextLine()) - 1;

        if (escCliente < 0 || escCliente >= listaClientes.size()) {
            System.out.println("cliente invalido !!!");
            return;
        }

        System.out.println("Selecione o numero do vendedor:");
        for (int i = 0; i < listaVendedores.size(); i++) {
            System.out.println((i + 1) + " - " + listaVendedores.get(i).getNome());
        }
        int escVendedor = Integer.parseInt(input.nextLine()) - 1;

        if (escVendedor < 0 || escVendedor >= listaVendedores.size()) {
            System.out.println("vendedor invalido !!!");
            return;
        }

        System.out.println("digite o id da venda:");
        int id = Integer.parseInt(input.nextLine());

        System.out.println("digite o valor total da venda:");
        double valor = Double.parseDouble(input.nextLine());

        Cliente clienteSel = listaClientes.get(escCliente);
        Vendedor vendedorSel = listaVendedores.get(escVendedor);

        Venda venda = new Venda(id, valor, clienteSel, vendedorSel);
        
        listaVendas.add(venda);
        clienteSel.adicionarVenda(venda);
        vendedorSel.adicionarVenda(venda);

        System.out.println("venda registrada e vinculada com suceso !!!");
    }

    public static void exibirResumoVendas() {
        if (listaVendas.isEmpty()) {
            System.out.println("nenhuma venda registrada atê o momento !!!");
            return;
        }

        for (Venda v : listaVendas) {
            v.exibeResumo();
        }
    }
}
