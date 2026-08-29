package atividade08_cursoaluno;

import java.util.ArrayList;
import java.util.Scanner;

class Aluno {

    private String nome;
    private String matricula;
    private Curso cursoMatriculado;

    public Aluno(String nome, String matricula, Curso cursoMatriculado) {
        this.nome = nome;
        this.matricula = matricula;
        this.cursoMatriculado = cursoMatriculado;
    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public Curso getCursoMatriculado() {
        return cursoMatriculado;
    }
}

class Curso {

    private String nomeCurso;
    private int vagasMaximas;
    private ArrayList<Aluno> listaAlunos;

    public Curso(String nomeCurso, int vagasMaximas) {
        this.nomeCurso = nomeCurso;
        this.vagasMaximas = vagasMaximas;
        this.listaAlunos = new ArrayList<>();
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public int getVagasMaximas() {
        return vagasMaximas;
    }

    public ArrayList<Aluno> getListaAlunos() {
        return listaAlunos;
    }

    public boolean temVagaDisponivel() {
        return this.listaAlunos.size() < this.vagasMaximas;
    }

    public boolean matricularAluno(Aluno aluno) {
        if (temVagaDisponivel()) {
            this.listaAlunos.add(aluno);
            return true;
        }
        return false;
    }
}

public class Main {

    static ArrayList<Curso> listaCursos = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao = 4;

        while (opcao != 0) {
            System.out.println("""
                           digite o numero referente a sua opção:
                           0 -  encerrar o programa.
                           1 -  Adicionar Curso.
                           2 -  Matricular Aluno em um Curso.
                           3 -  Consultar Alunos por Curso.
                           """);

            opcao = Integer.parseInt(input.nextLine());

            switch (opcao) {
                case 1:
                    criarCurso();
                    break;
                case 2:
                    cadastrarAluno();
                    break;
                case 3:
                    consultarCurso();
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

    public static void criarCurso() {
        System.out.println("digite o nome do curso:");
        String nome = input.nextLine();

        System.out.println("digite o limite maximo de vagas:");
        int vagas = Integer.parseInt(input.nextLine());

        Curso curso = new Curso(nome, vagas);
        listaCursos.add(curso);
        System.out.println("curso adicionado com sucesso !!!");
    }

    public static void cadastrarAluno() {
        if (listaCursos.isEmpty()) {
            System.out.println("nenhum curso cadastrado, tente outra operacao!!!");
            return;
        }

        System.out.println("Selecione o numero do curso para matricular o aluno:");
        for (int i = 0; i < listaCursos.size(); i++) {
            Curso c = listaCursos.get(i);
            System.out.println((i + 1) + " - " + c.getNomeCurso() + " (Vagas ocupadas: " + c.getListaAlunos().size() + "/" + c.getVagasMaximas() + ")");
        }

        int escolha = Integer.parseInt(input.nextLine()) - 1;

        if (escolha >= 0 && escolha < listaCursos.size()) {
            Curso cursoSelecionado = listaCursos.get(escolha);

            if (!cursoSelecionado.temVagaDisponivel()) {
                System.out.println("operacao cancelada: curso sem vagas disponiveis !!!");
                return;
            }

            System.out.println("digite o nome do aluno:");
            String nome = input.nextLine();

            System.out.println("digite a matricula do aluno:");
            String matricula = input.nextLine();

            Aluno alu = new Aluno(nome, matricula, cursoSelecionado);
            
            if (cursoSelecionado.matricularAluno(alu)) {
                System.out.println("aluno matriculado com sucesso !!!");
            } else {
                System.out.println("erro ao efetuar matricula !!!");
            }
        } else {
            System.out.println("digite um valor valido !!!");
        }
    }

    public static void consultarCurso() {
        if (listaCursos.isEmpty()) {
            System.out.println("nenhum curso cadastrado, tente outra operacao!!!");
            return;
        }

        System.out.println("Selecione o numero do curso que deseja consultar:");
        for (int i = 0; i < listaCursos.size(); i++) {
            System.out.println((i + 1) + " - " + listaCursos.get(i).getNomeCurso());
        }

        int escolha = Integer.parseInt(input.nextLine()) - 1;

        if (escolha >= 0 && escolha < listaCursos.size()) {
            Curso curso = listaCursos.get(escolha);
            ArrayList<Aluno> alunos = curso.getListaAlunos();

            System.out.println("alunos matriculados no curso " + curso.getNomeCurso() + " (" + alunos.size() + "/" + curso.getVagasMaximas() + " vagas):");
            if (alunos.isEmpty()) {
                System.out.println("nenhum aluno matriculado nesse curso !!!");
            } else {
                for (Aluno a : alunos) {
                    System.out.println("- Nome: " + a.getNome() + " | Matricula: " + a.getMatricula() + " | Curso: " + a.getCursoMatriculado().getNomeCurso());
                }
            }
        } else {
            System.out.println("digite um valor valido !!!");
        }
    }
}
//aqui quis adicionar um limite de alunos em curso pra ter um adicional ao exercicio