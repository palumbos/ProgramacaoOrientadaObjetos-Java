/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fibonacciBigInt;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {

        BigInteger n1 = BigInteger.ONE;
        BigInteger n2 = BigInteger.ONE;

        System.out.println(n1);
        System.out.println(n2);

        while (true) {
            BigInteger temp = n2;

            n2 = n2.add(n1);
            n1 = temp;

            System.out.println(n2);
        }
    }
}
