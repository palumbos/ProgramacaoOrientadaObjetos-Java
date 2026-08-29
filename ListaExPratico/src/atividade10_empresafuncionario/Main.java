package atividade10_empresafuncionario;

import java.util.ArrayList;
import java.util.Scanner;

class Funcionario {

    private String cpf;
    private String nome;
    private String cargo;

    public Funcionario(String cpf, String nome, String cargo) {
        this.cpf = cpf;
        this.nome = nome;
        this.cargo = cargo;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getCargo() {
        return cargo;
    }
}

class Empresa {

    private String cnpj;
    private String razãoSocial;
    private ArrayList<Funcionario> listaFuncionarios;

    public Empresa(String cnpj, String razãoSocial) {
        this.cnpj = cnpj;
        this.razãoSocial = razãoSocial;
        this.listaFuncionarios = new ArrayList<>();
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getRazãoSocial() {
        return razãoSocial;
    }

    public ArrayList<Funcionario> getListaFuncionarios() {
        return listaFuncionarios;
    }

    public void admitirFuncionario(Funcionario f) {
        this.listaFuncionarios.add(f);
    }
}

public class Main {

    static ArrayList<Empresa> listaEmpresas = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao = 4;

        while (opcao != 0) {
            System.out.println("""
                           digite o numero referente a sua opção:
                           0 -  encerrar o programa.
                           1 -  Adicionar Empresa.
                           2 -  Adicionar Funcionario a uma Empresa.
                           3 -  Consultar Funcionarios por Empresa.
                           """);

            opcao = Integer.parseInt(input.nextLine());

            switch (opcao) {
                case 1:
                    criarEmpresa();
                    break;
                case 2:
                    cadastrarFuncionario();
                    break;
                case 3:
                    consultarEmpresa();
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

    public static void criarEmpresa() {
        System.out.println("digite o CNPJ da empresa:");
        String cnpj = input.nextLine();

        System.out.println("digite a Razao Social da empresa:");
        String razãoSocial = input.nextLine();

        Empresa emp = new Empresa(cnpj, razãoSocial);
        listaEmpresas.add(emp);
        System.out.println("empresa adicionada com sucesso !!!");
    }

    public static void cadastrarFuncionario() {
        if (listaEmpresas.isEmpty()) {
            System.out.println("nenhuma empresa cadastrada, tente outra operacao!!!");
            return;
        }

        System.out.println("digite o CPF do funcionario:");
        String cpf = input.nextLine();

        System.out.println("digite o nome do funcionario:");
        String nome = input.nextLine();

        System.out.println("digite o cargo do funcionario:");
        String cargo = input.nextLine();

        System.out.println("Selecione o numero da empresa deste funcionario:");
        for (int i = 0; i < listaEmpresas.size(); i++) {
            System.out.println((i + 1) + " - " + listaEmpresas.get(i).getRazãoSocial());
        }

        int escolha = Integer.parseInt(input.nextLine()) - 1;

        if (escolha >= 0 && escolha < listaEmpresas.size()) {
            Funcionario func = new Funcionario(cpf, nome, cargo);
            listaEmpresas.get(escolha).admitirFuncionario(func);
            System.out.println("funcionario admitido com sucesso !!!");
        } else {
            System.out.println("digite um valor valido !!!");
        }
    }

    public static void consultarEmpresa() {
        if (listaEmpresas.isEmpty()) {
            System.out.println("nenhuma empresa cadastrada, tente outra operacao!!!");
            return;
        }

        System.out.println("Selecione o numero da empresa que deseja consultar:");
        for (int i = 0; i < listaEmpresas.size(); i++) {
            System.out.println((i + 1) + " - " + listaEmpresas.get(i).getRazãoSocial());
        }

        int escolha = Integer.parseInt(input.nextLine()) - 1;

        if (escolha >= 0 && escolha < listaEmpresas.size()) {
            Empresa emp = listaEmpresas.get(escolha);
            ArrayList<Funcionario> funcionarios = emp.getListaFuncionarios();

            System.out.println("Empresa: " + emp.getRazãoSocial() + " | CNPJ: " + emp.getCnpj());
            System.out.println("Quadros de Funcionarios:");
            if (funcionarios.isEmpty()) {
                System.out.println("nenhum funcionario cadastrado nesta empresa !!!");
            } else {
                for (Funcionario f : funcionarios) {
                    System.out.println("- CPF: " + f.getCpf() + " | Nome: " + f.getNome() + " | Cargo: " + f.getCargo());
                }
            }
        } else {
            System.out.println("digite um valor valido !!!");
        }
    }
}
