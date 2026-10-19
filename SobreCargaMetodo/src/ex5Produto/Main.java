
package ex5Produto;

public class Main {
    public static void main(String[] args) {
        Produto produto = new Produto(100.0);
        ProdutoPromocional promocional = new ProdutoPromocional(100.0);

        System.out.println("Desconto do produto: R$ " + produto.calcularDesconto());
        System.out.println("Desconto do produto promocional: R$ " + promocional.calcularDesconto());
    }
}
