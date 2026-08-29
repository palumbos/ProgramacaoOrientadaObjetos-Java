package atividade04_equipamentos;

import java.util.Scanner;

class EquipamentoInformatica {

    private int patrimonio;
    private String fabricante, descricao;
    private double valor;
    private boolean situacao;

    public EquipamentoInformatica(int patrimonio, String fabircante, double valor, String descricao, boolean situacao) {
        this.patrimonio = patrimonio;
        this.descricao = descricao;
        this.fabricante = fabricante;
        this.valor = valor;
        this.situacao = situacao;
    }

    public int getPatrimonio() {
        return patrimonio;
    }

    public String getFabricante() {
        return fabricante;
    }

    public double getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean getSituacao() {
        return situacao;
    }

    public void setSituacao(boolean novaSituacao) {
        this.situacao = novaSituacao;
    }

    public void setValor(int novoValor) {
        this.valor = novoValor;
    }
}

public class Main {

    static EquipamentoInformatica equipamento1;
    static EquipamentoInformatica equipamento2;
    static EquipamentoInformatica equipamento3;
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao = 4, patrimonio = 0;

        while (opcao != 0) {
            System.out.println("""
                           digite o numero referente a sua opção:
                           0 -  encerrar o programa.
                           1 -  Adicionar Equipamento.
                           2 -  Consultar Situação de uso de equipamento
                           3 -  Atualizar estado do equipamento
                           """);

            opcao = Integer.parseInt(input.nextLine());

            switch (opcao) {
                case 1: {
                    patrimonio++;
                    if (patrimonio <= 3) {
                        criarEquipamento(patrimonio);
                    } else {
                        System.out.println("voce atingiu o maximo de equipamentos, tente outra operação!!!");
                    }
                    break;
                }
                case 2:
                    consultarSituacao();
                    break;
                case 3:
                    atualizarValor();
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

    public static void criarEquipamento(int patrimonio) {
        String fabricante, descricao;
        double valor;
        boolean situacaoInicial = true;
        int situacao;
        System.out.println("o patrimonio desse equipamento é " + patrimonio);

        System.out.println("digite o fabricante do equipamento:");
        fabricante = input.nextLine();

        System.out.println("digite a descricao do equipamento:");
        descricao = input.nextLine();

        System.out.println("digite o valor inicial do equipamento:");
        valor = Double.parseDouble(input.nextLine());
        while (valor < 0) {
            System.out.println("o valor não pode ser negativo, tente novamente:");
            valor = Double.parseDouble(input.nextLine());
        }
            System.out.println("""
                               digite o numero referente a situação inicial do aparelho:
                               0- não sendo utilizado
                               1- sendo utilizado
                               """);
            situacao = Integer.parseInt(input.nextLine());
            while (situacao != 0 && situacao != 1) {
                System.out.println("digite um numero valido, \n 0- sendo utilizado \n 1- não sendo utilizado");
            situacao = Integer.parseInt(input.nextLine());
            }
            if (situacao == 0) {
                situacaoInicial = false;
            }

        
        switch (patrimonio) {
            case 1:
                equipamento1 = new EquipamentoInformatica(patrimonio, fabricante, valor, descricao, situacaoInicial);
                break;
            case 2:
                equipamento2 = new EquipamentoInformatica(patrimonio, fabricante, valor, descricao, situacaoInicial);
                break;
            case 3:
                equipamento3 = new EquipamentoInformatica(patrimonio, fabricante, valor, descricao, situacaoInicial);
                break;
        }

    }

    public static void consultarSituacao() {
        EquipamentoInformatica equipamento = buscarEquipamento();
        if (equipamento == null) {
            return;
        } else if (equipamento.getSituacao()) {
            System.out.println("o equipamento de patrimonio " + equipamento.getPatrimonio()
                    + " fabricante: " + equipamento.getFabricante() + " e descrição: " + equipamento.getDescricao() + " \npossue o preço: " + equipamento.getValor()
                    + "\n e no momento ele esta sendo utilizado!!!");
        } else {
            {
                System.out.println("o equipamento de patrimonio " + equipamento.getPatrimonio()
                        + " fabricante: " + equipamento.getFabricante() + " e descrição: " + equipamento.getDescricao() + " \npossue o preço: " + equipamento.getValor()
                        + "\n e no momento ele não esta sendo utilizado!!!");
            }
        }

    }

    public static void atualizarValor() {
        int n;
        double valor;
        EquipamentoInformatica equipamento = buscarEquipamento();
        if (equipamento == null) {
            return;
        }

        System.out.println(""" 
                           Digite o numero do oque voce quer atualizar:
                           1 -  valor
                           2 -  estado
                           digite qualquer outro numero para não fazer nenhuma operação
                           """);
        n = Integer.parseInt(input.nextLine());
        if (n == 1) {
            System.out.println("digite o novo valor do equipamento");
            valor = Double.parseDouble(input.nextLine());

        } else if (n == 2) {
            System.out.println("""
                               digite o numero referente a nova situação  do aparelho:
                               0- não sendo utilizado
                               1- sendo utilizado
                               """);
            n = Integer.parseInt(input.nextLine());
            while (n != 0 && n != 1) {
                System.out.println("digite um numero valido, \n 0- sendo utilizado \n 1- não sendo utilizado");
            }
            if (n == 0) {
                equipamento.setSituacao(false);
            } else {
                equipamento.setSituacao(true);
            }
        } else {
            System.out.println("nenhuma operação realizada, voltando ao menu!!!");
        }
    }

    public static EquipamentoInformatica buscarEquipamento() {
        System.out.println("""
                   Digite o número do equipamento que voce quer acessar (pela descricao):
                   1- %s
                   2- %s
                   3- %s
                   """.formatted(equipamento1 != null && equipamento1.getDescricao() != null ? equipamento1.getDescricao() : "Equipamento sem descricao",
                equipamento2 != null && equipamento2.getDescricao() != null ? equipamento2.getDescricao() : "Equipamento sem descricao",
                equipamento3 != null && equipamento3.getDescricao() != null ? equipamento3.getDescricao() : "Equipamento sem descricao"
        ));

        int n = Integer.parseInt(input.nextLine());

        switch (n) {
            case 1:
                if (equipamento1 != null) {
                    return equipamento1;
                }
                break;

            case 2:
                if (equipamento2 != null) {
                    return equipamento2;
                }
                break;

            case 3:
                if (equipamento3 != null) {
                    return equipamento3;
                }
                break;
        }

        System.out.println("Equipamento não encontrado!");
        return null;
    }
}
