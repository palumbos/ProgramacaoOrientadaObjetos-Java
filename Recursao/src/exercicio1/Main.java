
package exercicio1;

public class Main {
static void contagemDecrecente(int n) {
if (n == 0) {
System.out.println("Fim!");
return;
}
System.out.println(n);
contagemDecrecente(n - 1); // chama a si mesmo
}
public static void main(String[] args) {
contagemDecrecente(3);
}
}
