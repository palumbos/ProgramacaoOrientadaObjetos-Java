package joptionpane_contadorparimpar;

import javax.swing.JOptionPane;

public class Main {

    public static void main(String args[]) {
        int par = 0, impar = 0;
        int n = Integer.parseInt(JOptionPane.showInputDialog(null, "digite seu primeiro numero"));
        do {
            if (n != 0 && n % 2 == 0) {
                JOptionPane.showMessageDialog(null,
                        "O numero "+n+ " é par!!!",
                        "obrigado por digitar seus numeros",
                        JOptionPane.INFORMATION_MESSAGE);
                par++;

            } else if (n % 2 != 0) {
                JOptionPane.showMessageDialog(null,
                        "O numero "+n+" é impar!!",
                        "obrigado por digitar seus numeros",
                        JOptionPane.INFORMATION_MESSAGE);
                impar++;
            }

            n = Integer.parseInt(JOptionPane.showInputDialog(null, "digite seu proximo numero (zero apara terminar o programa"));

        } while (n != 0);

        JOptionPane.showMessageDialog(null,
                "Foram digitados " + (par + impar) + " numeros, sendo " + par + " pares e " + impar + " impares ",
                "obrigado por digitar seus numeros",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
