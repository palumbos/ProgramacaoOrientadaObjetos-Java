package atividade09_setorequipamento;

import java.util.ArrayList;
import java.util.Scanner;

class Equipamento {

    private String patrimonio;
    private String nome;
    private Setor setorInstalado;

    public Equipamento(String patrimonio, String nome, Setor setorInstalado) {
        this.patrimonio = patrimonio;
        this.nome = nome;
        this.setorInstalado = setorInstalado;
    }

    public String getPatrimonio() {
        return patrimonio;
    }

    public String getNome() {
        return nome;
    }

    public Setor getSetorInstalado() {
        return setorInstalado;
    }
}

class Setor {

    private String nomeSetor;
    private String responsavel;
    private ArrayList<Equipamento> listaEquipamentos;

    public Setor(String nomeSetor, String responsavel) {
        this.nomeSetor = nomeSetor;
        this.responsavel = responsavel;
        this.listaEquipamentos = new ArrayList<>();
    }

    public String getNomeSetor() {
        return nomeSetor;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public ArrayList<Equipamento> getListaEquipamentos() {
        return listaEquipamentos;
    }

    public void adicionarEquipamento(Equipamento eq) {
        this.listaEquipamentos.add(eq);
    }
}

public class Main {

    static ArrayList<Setor> listaSetores = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao = 4;

        while (opcao != 0) {
            System.out.println("""
                           digite o numero referente a sua opdção:
                           0 -  encerrar o programa.
                           1 -  Adicionar Setor.
                           2 -  Instalar Equipamento em um Setor.
                           3 -  Consultar Equipamentos por Setor.
                           """);

            opcao = Integer.parseInt(input.nextLine());

            switch (opcao) {
                case 1:
                    criarSetor();
                    break;
                case 2:
                    cadastrarEquipamento();
                    break;
                case 3:
                    consultarSetor();
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

    public static void criarSetor() {
        System.out.println("digite o nome do setor:");
        String nome = input.nextLine();

        System.out.println("digite o nome do responsavel pelo setor:");
        String responsavel = input.nextLine();

        Setor setor = new Setor(nome, responsavel);
        listaSetores.add(setor);
        System.out.println("setor adicionado com sucesso !!!");
    }

    public static void cadastrarEquipamento() {
        if (listaSetores.isEmpty()) {
            System.out.println("nenhum setor cadastrado, tente outra operacao!!!");
            return;
        }

        System.out.println("digite o codigo de patrimonio do equipamento:");
        String patrimonio = input.nextLine();

        System.out.println("digite o nome/descricao do equipamento:");
        String nome = input.nextLine();

        System.out.println("Selecione o numero do setor para instalar o equipamento:");
        for (int i = 0; i < listaSetores.size(); i++) {
            System.out.println((i + 1) + " - " + listaSetores.get(i).getNomeSetor());
        }

        int escolha = Integer.parseInt(input.nextLine()) - 1;

        if (escolha >= 0 && escolha < listaSetores.size()) {
            Setor setorSelecionado = listaSetores.get(escolha);
            Equipamento eq = new Equipamento(patrimonio, nome, setorSelecionado);
            setorSelecionado.adicionarEquipamento(eq);
            System.out.println("equipamento instalado e vinculado com sucesso !!!");
        } else {
            System.out.println("digite um valor valido !!!");
        }
    }

    public static void consultarSetor() {
        if (listaSetores.isEmpty()) {
            System.out.println("nenhum setor cadastrado, tente outra operacao!!!");
            return;
        }

        System.out.println("Selecione o numero do setor que deseja consultar:");
        for (int i = 0; i < listaSetores.size(); i++) {
            System.out.println((i + 1) + " - " + listaSetores.get(i).getNomeSetor());
        }

        int escolha = Integer.parseInt(input.nextLine()) - 1;

        if (escolha >= 0 && escolha < listaSetores.size()) {
            Setor setor = listaSetores.get(escolha);
            ArrayList<Equipamento> equipamentos = setor.getListaEquipamentos();

            System.out.println("Setor: " + setor.getNomeSetor() + " | Responsavel: " + setor.getResponsavel());
            System.out.println("Equipamentos instalados:");
            
            if (equipamentos.isEmpty()) {
                System.out.println("nenhum equipamento instalado neste setor !!!");
            } else {
                for (Equipamento eq : equipamentos) {
                    System.out.println("- Patrimonio: " + eq.getPatrimonio() + " | Nome: " + eq.getNome() + " | Setor de Origem: " + eq.getSetorInstalado().getNomeSetor());
                }
            }
        } else {
            System.out.println("digite um valor valido !!!");
        }
    }
}
