package atividade15_pacienteprofissionalconsulta;

import java.util.ArrayList;
import java.util.Scanner;

class Paciente {

    private String cpf;
    private String nome;

    public Paciente(String cpf, String nome) {
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

class Profissional {

    private String registroProfissional;
    private String nome;
    private String especialidade;

    public Profissional(String registroProfissional, String nome, String especialidade) {
        this.registroProfissional = registroProfissional;
        this.nome = nome;
        this.especialidade = especialidade;
    }

    public String getRegistroProfissional() {
        return registroProfissional;
    }

    public String getNome() {
        return nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }
}

class Consulta {

    private int idConsulta;
    private Paciente paciente;
    private Profissional profissional;
    private String data;
    private double valorAtendimento;

    public Consulta(int idConsulta, Paciente paciente, Profissional profissional, String data, double valorAtendimento) {
        this.idConsulta = idConsulta;
        this.paciente = paciente;
        this.profissional = profissional;
        this.data = data;
        this.valorAtendimento = valorAtendimento;
    }

    public int getIdConsulta() {
        return idConsulta;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public String getData() {
        return data;
    }

    public double getValorAtendimento() {
        return valorAtendimento;
    }

    public void exibirResumo() {
        System.out.println("REGISTRO DE CONSULTA #" + idConsulta);
        System.out.println("Paciente: " + paciente.getNome() + " (CPF: " + paciente.getCpf() + ")");
        System.out.println("Profissional: " + profissional.getNome() + " (" + profissional.getEspecialidade() + " - Reg: " + profissional.getRegistroProfissional() + ")");
        System.out.println("Data da consulta: " + data);
        System.out.println("Valor cobrado: R$ " + valorAtendimento);
    }
}

public class Main {

    static ArrayList<Paciente> listaPacientes = new ArrayList<>();
    static ArrayList<Profissional> listaProfissionais = new ArrayList<>();
    static ArrayList<Consulta> listaConsultas = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao = 5;

        while (opcao != 0) {
            System.out.println("""
                           digite o numero referente a sua opçao:
                           0 -  encerrar o programa.
                           1 -  Cadastrar Paciente.
                           2 -  Cadastrar Profissional.
                           3 -  Agendar/Registrar Consulta.
                           4 -  Consultar Atendimentos.
                           """);

            opcao = Integer.parseInt(input.nextLine());

            switch (opcao) {
                case 1:
                    cadastrarPaciente();
                    break;
                case 2:
                    cadastrarProfissional();
                    break;
                case 3:
                    registrarConsulta();
                    break;
                case 4:
                    consultarAtendimentos();
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

    public static void cadastrarPaciente() {
        System.out.println("digite o cpf do paciente:");
        String cpf = input.nextLine();

        System.out.println("digite o nome do paciente:");
        String nome = input.nextLine();

        Paciente p = new Paciente(cpf, nome);
        listaPacientes.add(p);
        System.out.println("paciente cadastrado com suceso !!!");
    }

    public static void cadastrarProfissional() {
        System.out.println("digite o registro do profissional (ex: CRM, CRO):");
        String reg = input.nextLine();

        System.out.println("digite o nome do profissional:");
        String nome = input.nextLine();

        System.out.println("digite a especialidade:");
        String esp = input.nextLine();

        Profissional prof = new Profissional(reg, nome, esp);
        listaProfissionais.add(prof);
        System.out.println("profissional cadastrado com suceso !!!");
    }

    public static void registrarConsulta() {
        if (listaPacientes.isEmpty()) {
            System.out.println("nenhum paciente cadastrado, tente outra operacao!!!");
            return;
        }

        if (listaProfissionais.isEmpty()) {
            System.out.println("nenhum profissional cadastrado, tente outra operacao!!!");
            return;
        }

        System.out.println("Selecione o paciente pelo numero:");
        for (int i = 0; i < listaPacientes.size(); i++) {
            System.out.println((i + 1) + " - " + listaPacientes.get(i).getNome() + " (CPF: " + listaPacientes.get(i).getCpf() + ")");
        }
        int escPaciente = Integer.parseInt(input.nextLine()) - 1;

        if (escPaciente < 0 || escPaciente >= listaPacientes.size()) {
            System.out.println("paciente invalido !!!");
            return;
        }

        System.out.println("Selecione o profissional pelo numero:");
        for (int i = 0; i < listaProfissionais.size(); i++) {
            Profissional prof = listaProfissionais.get(i);
            System.out.println((i + 1) + " - " + prof.getNome() + " (" + prof.getEspecialidade() + " - Reg: " + prof.getRegistroProfissional() + ")");
        }
        int escProfissional = Integer.parseInt(input.nextLine()) - 1;

        if (escProfissional < 0 || escProfissional >= listaProfissionais.size()) {
            System.out.println("profissional invalido !!!");
            return;
        }

        System.out.println("digite o id da consulta:");
        int id = Integer.parseInt(input.nextLine());

        System.out.println("digite a data da consulta (ex: 20/10/2026):");
        String data = input.nextLine();

        System.out.println("digite o valor do atendimento:");
        double valor = Double.parseDouble(input.nextLine());

        Paciente pacienteSel = listaPacientes.get(escPaciente);
        Profissional profSel = listaProfissionais.get(escProfissional);

        Consulta c = new Consulta(id, pacienteSel, profSel, data, valor);
        listaConsultas.add(c);

        System.out.println("consulta registrada com suceso !!!");
    }

    public static void consultarAtendimentos() {
        if (listaConsultas.isEmpty()) {
            System.out.println("nenhuma consulta registrada atê o momento !!!");
            return;
        }

        for (Consulta c : listaConsultas) {
            c.exibirResumo();
        }
    }
}
//nesse eu coloquei dentro do construtor da consulta o paciente e o profissional inteiros, para facilitar a navegação e asociação