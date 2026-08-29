package atividade14_ordemservico;

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

class Equipamento {

    private String numeroSerie;
    private String tipo;
    private String marca;

    public Equipamento(String numeroSerie, String tipo, String marca) {
        this.numeroSerie = numeroSerie;
        this.tipo = tipo;
        this.marca = marca;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public String getTipo() {
        return tipo;
    }

    public String getMarca() {
        return marca;
    }
}

class OrdemServico {

    private int numeroOS;
    private Cliente cliente;
    private Equipamento equipamento;
    private String problemaRelatado;
    private double valorServico;
    private String situacao;

    public OrdemServico(int numeroOS, Cliente cliente, Equipamento equipamento, String problemaRelatado, double valorServico) {
        this.numeroOS = numeroOS;
        this.cliente = cliente;
        this.equipamento = equipamento;
        this.problemaRelatado = problemaRelatado;
        this.valorServico = valorServico;
        this.situacao = "Em Aberto";
    }

    public int getNumeroOS() {
        return numeroOS;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public String getProblemaRelatado() {
        return problemaRelatado;
    }

    public double getValorServico() {
        return valorServico;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public void exibirResumo() {
        System.out.println("ORDEM DE SERVIÇO N° " + numeroOS);
        System.out.println("Cliente: " + cliente.getNome() + " | CPF: " + cliente.getCpf());
        System.out.println("Equipamento: " + equipamento.getTipo() + " " + equipamento.getMarca() + " (Serie: " + equipamento.getNumeroSerie() + ")");
        System.out.println("Defeito relatado: " + problemaRelatado);
        System.out.println("Valor do conserto: R$ " + valorServico);
        System.out.println("Situaçao atual: " + situacao);
    }
}

public class Main {

    static ArrayList<Cliente> listaClientes = new ArrayList<>();
    static ArrayList<Equipamento> listaEquipamentos = new ArrayList<>();
    static ArrayList<OrdemServico> listaOrdens = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao = 6;

        while (opcao != 0) {
            System.out.println("""
                           digite o numero referente a sua opçao:
                           0 -  encerrar o programa.
                           1 -  Cadastrar Cliente.
                           2 -  Cadastrar Equipamento.
                           3 -  Abrir Ordem de Serviço.
                           4 -  Atualizar Situaçao da OS.
                           5 -  Consultar todas as OS.
                           """);

            opcao = Integer.parseInt(input.nextLine());

            switch (opcao) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    cadastrarEquipamento();
                    break;
                case 3:
                    abrirOrdemServico();
                    break;
                case 4:
                    atualizarSituacaoOS();
                    break;
                case 5:
                    consultarOrdens();
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

    public static void cadastrarEquipamento() {
        System.out.println("digite o numero de serie do aparelho:");
        String serie = input.nextLine();

        System.out.println("digite o tipo do equipamento (ex: Notebook, Celular):");
        String tipo = input.nextLine();

        System.out.println("digite a marca do aparelho:");
        String marca = input.nextLine();

        Equipamento eq = new Equipamento(serie, tipo, marca);
        listaEquipamentos.add(eq);
        System.out.println("equipamento cadastrado com suceso !!!");
    }

    public static void abrirOrdemServico() {
        if (listaClientes.isEmpty()) {
            System.out.println("nenhum cliente cadastrado, tente outra operacao!!!");
            return;
        }

        if (listaEquipamentos.isEmpty()) {
            System.out.println("nenhum equipamento cadastrado, tente outra operacao!!!");
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

        System.out.println("Selecione o numero do equipamento:");
        for (int i = 0; i < listaEquipamentos.size(); i++) {
            Equipamento eq = listaEquipamentos.get(i);
            System.out.println((i + 1) + " - " + eq.getTipo() + " " + eq.getMarca() + " (SN: " + eq.getNumeroSerie() + ")");
        }
        int escEquipamento = Integer.parseInt(input.nextLine()) - 1;

        if (escEquipamento < 0 || escEquipamento >= listaEquipamentos.size()) {
            System.out.println("equipamento invalido !!!");
            return;
        }

        System.out.println("digite o numero da OS:");
        int numero = Integer.parseInt(input.nextLine());

        System.out.println("descreva o problema relatado pelo cliente:");
        String problema = input.nextLine();

        System.out.println("digite o valor orçado para o serviço:");
        double valor = Double.parseDouble(input.nextLine());

        Cliente clienteSel = listaClientes.get(escCliente);
        Equipamento equipamentoSel = listaEquipamentos.get(escEquipamento);

        OrdemServico os = new OrdemServico(numero, clienteSel, equipamentoSel, problema, valor);
        listaOrdens.add(os);

        System.out.println("ordem de servico aberta com suceso !!!");
    }

    public static void atualizarSituacaoOS() {
        if (listaOrdens.isEmpty()) {
            System.out.println("nenhuma ordem de servico cadastrada !!!");
            return;
        }

        System.out.println("Selecione a OS que deseja alterar o status:");
        for (int i = 0; i < listaOrdens.size(); i++) {
            OrdemServico os = listaOrdens.get(i);
            System.out.println((i + 1) + " - OS N° " + os.getNumeroOS() + " | Status atual: " + os.getSituacao());
        }
        int escolha = Integer.parseInt(input.nextLine()) - 1;

        if (escolha >= 0 && escolha < listaOrdens.size()) {
            System.out.println("digite o novo status (ex: Em Manutencao, Aguardando Peça, Concluido):");
            String novoStatus = input.nextLine();
            listaOrdens.get(escolha).setSituacao(novoStatus);
            System.out.println("status atualizado com suceso !!!");
        } else {
            System.out.println("digite um valor valido !!!");
        }
    }

    public static void consultarOrdens() {
        if (listaOrdens.isEmpty()) {
            System.out.println("nenhuma ordem de servico registrada atê o momento !!!");
            return;
        }

        for (OrdemServico os : listaOrdens) {
            os.exibirResumo();
        }
    }
}
