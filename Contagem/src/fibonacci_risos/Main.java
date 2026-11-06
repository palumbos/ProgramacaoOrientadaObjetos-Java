package fibonacci_risos;

public class Main {

    public static void main(String[] args) {
        long n1 = 1, n2 = 1;

        System.out.println(n1);
        System.out.println(n2);

        while (true) {
            long temp = n2;

            n2 = n2 + n1;
            n1 = temp;

            if (n2 < 0) {
                break;
            }

            System.out.println(n2);
        }
    }

}
