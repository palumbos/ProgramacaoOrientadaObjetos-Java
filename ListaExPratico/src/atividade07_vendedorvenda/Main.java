package atividade07_vendedorvenda;
import java.util.ArrayList;
import java.util.Scanner;

class Venda {

    private int numero;
    private double valor;

    public Venda(int numero, double valor) {
        this.numero = numero;
        this.valor = valor;
    }

    public int getNumero() {
        return numero;
    }

    public double getValor() {
        return valor;
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

    public double calcularComissaoTotal() {
        double totalVendas = 0;
        for (Venda v : listaVendas) {
            totalVendas += v.getValor();
        }
        return totalVendas * (this.percentualComissao / 100.0);
    }
}

public class Main {

    static ArrayList<Vendedor> listaVendedores = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao = 4;

        while (opcao != 0) {
            System.out.println("""
                           digite o numero referente a sua opção:
                           0 -  encerrar o programa.
                           1 -  Adicionar Vendedor.
                           2 -  Adicionar Venda para um Vendedor.
                           3 -  Consultar vendas e comissão do Vendedor.
                           """);

            opcao = Integer.parseInt(input.nextLine());

            switch (opcao) {
                case 1:
                    criarVendedor();
                    break;
                case 2:
                    cadastrarVenda();
                    break;
                case 3:
                    consultarVendedor();
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

    public static void criarVendedor() {
        System.out.println("digite o nome do vendedor:");
        String nome = input.nextLine();

        System.out.println("digite a porcentagem de comissao (ex: 10 para 10%):");
        double comissao = Double.parseDouble(input.nextLine());

        Vendedor vend = new Vendedor(nome, comissao);
        listaVendedores.add(vend);
        System.out.println("vendedor adicionado com sucesso !!!");
    }

    public static void cadastrarVenda() {
        if (listaVendedores.isEmpty()) {
            System.out.println("nenhum vendedor cadastrado, tente outra operacao!!!");
            return;
        }

        System.out.println("digite o numero da venda:");
        int numero = Integer.parseInt(input.nextLine());

        System.out.println("digite o valor da venda:");
        double valor = Double.parseDouble(input.nextLine());

        System.out.println("Selecione o numero do vendedor desta venda:");
        for (int i = 0; i < listaVendedores.size(); i++) {
            System.out.println((i + 1) + " - " + listaVendedores.get(i).getNome());
        }

        int escolha = Integer.parseInt(input.nextLine()) - 1;

        if (escolha >= 0 && escolha < listaVendedores.size()) {
            Venda v = new Venda(numero, valor);
            listaVendedores.get(escolha).adicionarVenda(v);
            System.out.println("venda vinculada com sucesso !!!");
        } else {
            System.out.println("digite um valor valido !!!");
        }
    }

    public static void consultarVendedor() {
        if (listaVendedores.isEmpty()) {
            System.out.println("nenhum vendedor cadastrado, tente outra operacao!!!");
            return;
        }

        System.out.println("Selecione o numero do vendedor que deseja consultar:");
        for (int i = 0; i < listaVendedores.size(); i++) {
            System.out.println((i + 1) + " - " + listaVendedores.get(i).getNome());
        }

        int escolha = Integer.parseInt(input.nextLine()) - 1;

        if (escolha >= 0 && escolha < listaVendedores.size()) {
            Vendedor vend = listaVendedores.get(escolha);
            ArrayList<Venda> vendas = vend.getListaVendas();

            System.out.println("vendas do vendedor " + vend.getNome() + ":");
            if (vendas.isEmpty()) {
                System.out.println("nenhuma venda cadastrada para esse vendedor !!!");
            } else {
                for (Venda v : vendas) {
                    System.out.println("- Venda N°: " + v.getNumero() + " | Valor: R$ " + v.getValor());
                }
                System.out.println("Comissao Total Acumulada (" + vend.getPercentualComissao() + "%): R$ " + vend.calcularComissaoTotal());
            }
        } else {
            System.out.println("digite um valor valido !!!");
        }
    }
}
// o exercicio segue a exata mesma logica do 5 e 6, porem com o cauculo da comissão como o difrenciall
