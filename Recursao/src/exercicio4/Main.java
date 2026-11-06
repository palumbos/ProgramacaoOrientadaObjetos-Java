
package exercicio4;

public class Main {
public static long fatorial(int n) {
if (n < 0) {
throw new IllegalArgumentException("n negativo");
}
if (n <= 1) {
return 1; 
}
return n * fatorial(n - 1); 
}
public static void main(String[] args) {
System.out.println(fatorial(5));
System.out.println(fatorial(20));
}
}


