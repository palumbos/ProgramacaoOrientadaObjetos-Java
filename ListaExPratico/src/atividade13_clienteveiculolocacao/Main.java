package atividade13_clienteveiculolocacao;

import java.util.ArrayList;
import java.util.Scanner;

class Cliente {

    private String cpf;
    private String nome;

    public Cliente(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }
}

class Veiculo {

    private String placa;
    private String modelo;
    private double valorDiaria;

    public Veiculo(String placa, String modelo, double valorDiaria) {
        this.placa = placa;
        this.modelo = modelo;
        this.valorDiaria = valorDiaria;
    }

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }
}

class Locacao {

    private int id;
    private Cliente cliente;
    private Veiculo veiculo;
    private int diasLocados;

    public Locacao(int id, Cliente cliente, Veiculo veiculo, int diasLocados) {
        this.id = id;
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.diasLocados = diasLocados;
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public int getDiasLocados() {
        return diasLocados;
    }

    public double calcularValorTotal() {
        return this.veiculo.getValorDiaria() * this.diasLocados;
    }

    public void exibirResumo() {
        System.out.println("DETALHES DA LOCACAO #" + id );
        System.out.println("Cliente: " + cliente.getNome() + " (CPF: " + cliente.getCpf() + ")");
        System.out.println("Veiculo: " + veiculo.getModelo() + " | Placa: " + veiculo.getPlaca());
        System.out.println("Valor da diaria: R$ " + veiculo.getValorDiaria());
        System.out.println("Quantidade de dias: " + diasLocados);
        System.out.println("Valor total da locacao: R$ " + calcularValorTotal());
    }
}

public class Main {

    static ArrayList<Cliente> listaClientes = new ArrayList<>();
    static ArrayList<Veiculo> listaVeiculos = new ArrayList<>();
    static ArrayList<Locacao> listaLocacoes = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao = 5;

        while (opcao != 0) {
            System.out.println("""
                           digite o numero referente a sua opçao:
                           0 -  encerrar o programa.
                           1 -  Cadastrar Cliente.
                           2 -  Cadastrar Veiculo.
                           3 -  Registrar Locaçao.
                           4 -  Consultar Locaçoes.
                           """);

            opcao = Integer.parseInt(input.nextLine());

            switch (opcao) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    cadastrarVeiculo();
                    break;
                case 3:
                    registrarLocacao();
                    break;
                case 4:
                    consultarLocacoes();
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
        System.out.println("digite o cpf do cliente:");
        String cpf = input.nextLine();

        System.out.println("digite o nome do cliente:");
        String nome = input.nextLine();

        Cliente c = new Cliente(cpf, nome);
        listaClientes.add(c);
        System.out.println("cliente cadastrado com suceso !!!");
    }

    public static void cadastrarVeiculo() {
        System.out.println("digite a placa do veiculo:");
        String placa = input.nextLine();

        System.out.println("digite o modelo do veiculo:");
        String modelo = input.nextLine();

        System.out.println("digite o valor da diaria do veiculo:");
        double diaria = Double.parseDouble(input.nextLine());

        Veiculo v = new Veiculo(placa, modelo, diaria);
        listaVeiculos.add(v);
        System.out.println("veiculo cadastrado com suceso !!!");
    }

    public static void registrarLocacao() {
        if (listaClientes.isEmpty()) {
            System.out.println("nenhum cliente cadastrado, tente outra operacao!!!");
            return;
        }

        if (listaVeiculos.isEmpty()) {
            System.out.println("nenhum veiculo cadastrado no sistema, tente outra operacao!!!");
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

        System.out.println("Selecione o numero do veiculo:");
        for (int i = 0; i < listaVeiculos.size(); i++) {
            System.out.println((i + 1) + " - " + listaVeiculos.get(i).getModelo() + " (R$ " + listaVeiculos.get(i).getValorDiaria() + "/dia)");
        }
        int escVeiculo = Integer.parseInt(input.nextLine()) - 1;

        if (escVeiculo < 0 || escVeiculo >= listaVeiculos.size()) {
            System.out.println("veiculo invalido !!!");
            return;
        }

        System.out.println("digite o id da locaçao:");
        int id = Integer.parseInt(input.nextLine());

        System.out.println("digite a quantidade de dias da locaçao:");
        int dias = Integer.parseInt(input.nextLine());

        Cliente clienteSel = listaClientes.get(escCliente);
        Veiculo veiculoSel = listaVeiculos.get(escVeiculo);

        Locacao loc = new Locacao(id, clienteSel, veiculoSel, dias);
        listaLocacoes.add(loc);

        System.out.println("locaçao registrada com suceso! Total a pagar: R$ " + loc.calcularValorTotal());
    }

    public static void consultarLocacoes() {
        if (listaLocacoes.isEmpty()) {
            System.out.println("nenhuma locaçao registrada atê o momento !!!");
            return;
        }

        for (Locacao loc : listaLocacoes) {
            loc.exibirResumo();

        }
    }
}
