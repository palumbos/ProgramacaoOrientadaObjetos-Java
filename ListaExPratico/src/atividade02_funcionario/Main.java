package atividade02_funcionario;

import java.util.Scanner;

class Funcionario {

    private int matricula;
    private String nome;
    private char categoria;
    private float salario;

    public Funcionario(int matricula, String nome, char categoria, float salario) {
        this.matricula = matricula;
        this.nome = nome;
        this.categoria = categoria;
        this.salario = salario;
    }

    public int getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public char getCategoria() {
        return categoria;
    }

    public float getSalario() {
        return salario;
    }

    public void exibirDados() {
        System.out.println("Matrícula: " + matricula);
        System.out.println("Nome: " + nome);
        System.out.println("Categoria: " + categoria);
        System.out.println("Salário: " + salario);
    }

    public void acrescimoSalario(float reajuste) {
        salario = salario * (1 + reajuste / 100);
    }

    public void decrescimoSalario(float reajuste) {
        salario = salario * (1 - reajuste / 100);
    }
}

public class Main {

    static Scanner input = new Scanner(System.in);

    static Funcionario func1;
    static Funcionario func2;
    static Funcionario func3;
    static Funcionario func4;
    static Funcionario func5;

    public static void main(String[] args) {

        int opcao = 1;
        int codigo = 0;

        while (opcao != 0) {

            System.out.println("""
                    0 - Sair
                    1 - Criar funcionário
                    2 - Consultar funcionário
                    3 - Reajustar salário
                    """);

            opcao = Integer.parseInt(input.nextLine());

            switch (opcao) {

                case 1:
                    codigo++;

                    System.out.println("Digite a matrícula:");
                    int matricula = Integer.parseInt(input.nextLine());

                    System.out.println("Digite o nome:");
                    String nome = input.nextLine();

                    System.out.println("Digite a categoria:");
                    char categoria = input.nextLine().charAt(0);

                    System.out.println("Digite o salário:");
                    float salario = Float.parseFloat(input.nextLine());

                    switch (codigo) {
                        case 1:
                            func1 = new Funcionario(matricula, nome, categoria, salario);
                            break;
                        case 2:
                            func2 = new Funcionario(matricula, nome, categoria, salario);
                            break;
                        case 3:
                            func3 = new Funcionario(matricula, nome, categoria, salario);
                            break;
                        case 4:
                            func4 = new Funcionario(matricula, nome, categoria, salario);
                            break;
                        case 5:
                            func5 = new Funcionario(matricula, nome, categoria, salario);
                            break;
                        default:
                            System.out.println("Máximo de funcionários atingido!");
                    }

                    break;

                case 2:
                    System.out.println("Digite o número do funcionário (1 a 5):");
                    int n = Integer.parseInt(input.nextLine());

                    switch (n) {
                        case 1:
                            func1.exibirDados();
                            break;
                        case 2:
                            func2.exibirDados();
                            break;
                        case 3:
                            func3.exibirDados();
                            break;
                        case 4:
                            func4.exibirDados();
                            break;
                        case 5:
                            func5.exibirDados();
                            break;
                    }

                    break;

                case 3:
                    System.out.println("Digite o número do funcionário (1 a 5):");
                    n = Integer.parseInt(input.nextLine());

                    System.out.println("Digite a porcentagem do reajuste:");
                    float reajuste = Float.parseFloat(input.nextLine());

                    System.out.println("1 - Acréscimo");
                    System.out.println("2 - Decréscimo");

                    int tipo = Integer.parseInt(input.nextLine());

                    switch (n) {
                        case 1:
                            if (tipo == 1)
                                func1.acrescimoSalario(reajuste);
                            else
                                func1.decrescimoSalario(reajuste);
                            break;

                        case 2:
                            if (tipo == 1)
                                func2.acrescimoSalario(reajuste);
                            else
                                func2.decrescimoSalario(reajuste);
                            break;

                        case 3:
                            if (tipo == 1)
                                func3.acrescimoSalario(reajuste);
                            else
                                func3.decrescimoSalario(reajuste);
                            break;

                        case 4:
                            if (tipo == 1)
                                func4.acrescimoSalario(reajuste);
                            else
                                func4.decrescimoSalario(reajuste);
                            break;

                        case 5:
                            if (tipo == 1)
                                func5.acrescimoSalario(reajuste);
                            else
                                func5.decrescimoSalario(reajuste);
                            break;
                    }

                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }

        input.close();
    }
}
