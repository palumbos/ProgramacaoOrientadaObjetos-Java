package atividade_01;

import java.util.Scanner;

class Produto {

    private int codigo, estoque;
    private double preco;
    private String nome, descricao;

    public Produto(String nome, String descricao, int codigo, float preco, int quantidadeEstoque) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.estoque = quantidadeEstoque;
    }

    public int getEstoque() {
        return estoque;
    }

    public double getPreco() {
        return preco;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}

public class Main {

    static Produto produto1;
    static Produto produto2;
    static Produto produto3;
    static Produto produto4;
    static Produto produto5;

    static Scanner input = new Scanner(System.in);
    static int codigo = 0;

    public static void main(String args[]) {
        int opcao = 4;

        while (opcao != 0) {
            System.out.println("""
                           digite o numero referente a sua opção:
                           0 - digite 0 para encerrar o programa.
                           1 - digite 1 se voce deseja criar um Produto.
                           2 - digite 2 se voce deseja consultar o estoque o preço a descrição e o nome de algum produto.
                           3 - digite 3 se voce deseja atualizar algum produto existente.
                           """);

            opcao = Integer.parseInt(input.nextLine());

            switch (opcao) {
                case 1: {
                    codigo++;
                    criarProduto(codigo);
                    break;
                }
                case 2:
                    consultarEstoque();
                    break;
                case 3:
                    modificarEstoque();
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

    public static void criarProduto(int codigo) {

        String nome, descricao;
        int estoque;
        float preco;

        if (codigo > 5) {
            System.out.println("voce cadastrou o maximo de produtos, Voltando ao Menu !!!");
        } else {
            System.out.println("digite o nome do seu produto");
            nome = input.nextLine();

            System.out.println("digite a descriçao do seu produto");
            descricao = input.nextLine();

            System.out.println("digite a quantidade no estoque desse produto");
            estoque = Integer.parseInt(input.nextLine());

            System.out.println("digite o preço do produto");
            preco = Float.parseFloat(input.nextLine());

            switch (codigo) {
                case 1:
                    produto1 = new Produto(nome, descricao, codigo, preco, estoque);
                    break;
                case 2:
                    produto2 = new Produto(nome, descricao, codigo, preco, estoque);
                    break;
                case 3:
                    produto3 = new Produto(nome, descricao, codigo, preco, estoque);
                    break;
                case 4:
                    produto4 = new Produto(nome, descricao, codigo, preco, estoque);
                    break;
                case 5:
                    produto5 = new Produto(nome, descricao, codigo, preco, estoque);
                    break;
            }
        }
    }

    public static void consultarEstoque() {
        System.out.println("\n \n \n \n ");

        System.out.println("digite o codigo do produto que voce quer consultar (o codigo começou em 1 no primeiro produto aumentou de 1 em 1 a cada produto adicionado");
        int n = Integer.parseInt(input.nextLine());

        switch (n) {
            case 1: {
                System.out.println("o produto: " + produto1.getNome() + "\n tem a descrição: " + produto1.getDescricao() + " \n com o preço: " + produto1.getPreco() + " \ne a quantidade no estoque é " + produto1.getEstoque());
                break;
            }
            case 2: {
                System.out.println("o produto: " + produto2.getNome() + "\n tem a descrição: " + produto2.getDescricao() + " \n com o preço: " + produto2.getPreco() + "\n e a quantidade no estoque é " + produto2.getEstoque());
                break;
            }
            case 3: {
                System.out.println("o produto: " + produto3.getNome() + "\n tem a descrição: " + produto3.getDescricao() + " \n com o preço: " + produto3.getPreco() + "\n e a quantidade no estoque é " + produto3.getEstoque());
                break;
            }
            case 4: {
                System.out.println("o produto: " + produto4.getNome() + "\n tem a descrição: " + produto4.getDescricao() + " \n com o preço: " + produto4.getPreco() + "\n e a quantidade no estoque é " + produto4.getEstoque());
                break;
            }
            case 5: {
                System.out.println("o produto: " + produto5.getNome() + "\n tem a descrição: " + produto5.getDescricao() + " \n com o preço: " + produto5.getPreco() + "\n e a quantidade no estoque é " + produto5.getEstoque());
                break;
            }
        }

        System.out.println("\n \n \n \n ");
    }

    public static void modificarEstoque() {
        System.out.println("digite o codigo do produto que voce quer alterar o preco");
        int codigo = Integer.parseInt(input.nextLine());

        System.out.println("Digite o novo preço:");
        double preco = Double.parseDouble(input.nextLine());

        switch (codigo) {
            case 1:
                produto1.setPreco(preco);
                break;
            case 2:
                produto2.setPreco(preco);
                break;
            case 3:
                produto3.setPreco(preco);
                break;
            case 4:
                produto4.setPreco(preco);
                break;
            case 5:
                produto5.setPreco(preco);
                break;
        }
    }
}
