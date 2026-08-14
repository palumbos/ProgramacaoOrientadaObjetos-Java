package joptionpane_cadastroalunos;

import javax.swing.JOptionPane;

public class Main {

    public static void main(String args[]) {
        
        
        int n = Integer.parseInt(JOptionPane.showInputDialog(null, "digite quantos Alunos são"));

        String[] nome = new String[n];
        int[] idade = new int[n];

        for (int i = 0; i < n; i++) {
            nome[i] = JOptionPane.showInputDialog(null, "digite o nome do aluno " + i);

            idade[i] = Integer.parseInt(JOptionPane.showInputDialog(null, "digite a idade do aluno " + i));
        }

        for (int i = 0; i < n; i++) {
            JOptionPane.showMessageDialog(null,
                    "aluno: " + (i + 1) + " \n " + "nome: " + nome[i] + " \n " + "idade: " + idade[i],
                    "apresentação",
                    JOptionPane.INFORMATION_MESSAGE);
        }

    }
}
