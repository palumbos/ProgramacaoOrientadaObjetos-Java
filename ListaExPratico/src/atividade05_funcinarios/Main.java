package atividade05_funcinarios;

import java.util.ArrayList;
import java.util.Scanner;

class Funcionario {

    private String nome;
    private String cargo;

    public Funcionario(String nome, String cargo) {
        this.nome = nome;
        this.cargo = cargo;
    }

    public String getNome() {
        return nome;
    }

    public String getCargo() {
        return cargo;
    }
}

class Departamento {

    private String nomeDepartamento;
    private ArrayList<Funcionario> listaFuncionarios;

    public Departamento(String nomeDepartamento) {
        this.nomeDepartamento = nomeDepartamento;
        this.listaFuncionarios = new ArrayList<>();
    }

    public String getNomeDepartamento() {
        return nomeDepartamento;
    }

    public ArrayList<Funcionario> getListaFuncionarios() {
        return listaFuncionarios;
    }

    public void adicionarFuncionario(Funcionario f) {
        this.listaFuncionarios.add(f);
    }
}

public class Main {

    static ArrayList<Departamento> listaDepartamentos = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao = 4;

        while (opcao != 0) {
            System.out.println("""
                           digite o numero referente a sua opção:
                           0 -  encerrar o programa.
                           1 -  Adicionar Departamento.
                           2 -  Adicionar Funcionario em um Departamento.
                           3 -  Consultar Funcionarios por Departamento.
                           """);

            opcao = Integer.parseInt(input.nextLine());

            switch (opcao) {
                case 1:
                    criarDepartamento();
                    break;
                case 2:
                    cadastrarFuncionario();
                    break;
                case 3:
                    consultarDepartamento();
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

    public static void criarDepartamento() {
        System.out.println("digite o nome do departamento:");
        String nome = input.nextLine();

        Departamento depto = new Departamento(nome);
        listaDepartamentos.add(depto);
        System.out.println("departamento adicionado com sucesso !!!");
    }

    public static void cadastrarFuncionario() {
        if (listaDepartamentos.isEmpty()) {
            System.out.println("nenhum departamento cadastrado, tente outra operacao!!!");
            return;
        }

        System.out.println("digite o nome do funcionario:");
        String nome = input.nextLine();

        System.out.println("digite o cargo do funcionario:");
        String cargo = input.nextLine();

        System.out.println("Selecione o numero do departamento deste funcionario:");
        for (int i = 0; i < listaDepartamentos.size(); i++) {
            System.out.println((i + 1) + " - " + listaDepartamentos.get(i).getNomeDepartamento());
        }

        int escolha = Integer.parseInt(input.nextLine()) - 1;

        if (escolha >= 0 && escolha < listaDepartamentos.size()) {
            Funcionario func = new Funcionario(nome, cargo);
            listaDepartamentos.get(escolha).adicionarFuncionario(func);
            System.out.println("funcionario vinculado com sucesso !!!");
        } else {
            System.out.println("digite um valor valido !!!");
        }
    }

    public static void consultarDepartamento() {
        if (listaDepartamentos.isEmpty()) {
            System.out.println("nenhum departamento cadastrado, tente outra operacao!!!");
            return;
        }

        System.out.println("Selecione o numero do departamento que deseja consultar:");
        for (int i = 0; i < listaDepartamentos.size(); i++) {
            System.out.println((i + 1) + " - " + listaDepartamentos.get(i).getNomeDepartamento());
        }

        int escolha = Integer.parseInt(input.nextLine()) - 1;

        if (escolha >= 0 && escolha < listaDepartamentos.size()) {
            Departamento depto = listaDepartamentos.get(escolha);
            ArrayList<Funcionario> funcionarios = depto.getListaFuncionarios();

            System.out.println("funcionarios do departamento " + depto.getNomeDepartamento() + ":");
            if (funcionarios.isEmpty()) {
                System.out.println("nenhum funcionario cadastrado nesse departamento !!!");
            } else {
                for (int i = 0; i < funcionarios.size(); i++) {
                    System.out.println("- " + funcionarios.get(i).getNome() + " | cargo: " + funcionarios.get(i).getCargo());
                }
            }
        } else {
            System.out.println("digite um valor valido !!!");
        }
    }
}
// nessa eu adotei o array list que é muito melhor do que eu tava fazendo nos exercicios anteriores de criar 3 objetos fixos (ou 5) e usar um swich case pra escolher