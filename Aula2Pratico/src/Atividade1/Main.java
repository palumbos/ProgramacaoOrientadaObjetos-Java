package Atividade1;

import java.util.Scanner;

class Aluno {
    int matricula, idade;
    String nome;
    float nota;

    public Aluno(String nome, int idade, int matricula, float nota) {
        this.matricula = matricula;
        this.nome = nome;
        this.idade = idade;
        this.nota = nota;
    }

    public void apresentar() {
        System.out.println("O aluno  " + nome +
                ", com idade de " + idade +
                " e matrícula " + matricula);
    }

    public void situarAprovacao() {
        if (nota >= 6) {
            System.out.println("Aprovado");
        } else {
            System.out.println(" a situação dele é Reprovado");
        }
    }
}

public class Main {
            static Scanner input = new Scanner(System.in);


    public static void main(String args[]) {
        System.out.println("digite a matricula do aluno que voce quer cadastrar (digite 0 para encerrar)");
        int matricula = input.nextInt;

}
}
