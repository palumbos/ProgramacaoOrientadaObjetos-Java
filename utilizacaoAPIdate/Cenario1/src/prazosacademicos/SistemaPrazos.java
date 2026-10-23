
package prazosacademicos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SistemaPrazos {
    public static void main(String[] args) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        List<Atividade> lista = new ArrayList<>();

        lista.add(new Atividade("Trabalho de POO", LocalDateTime.of(2026, 10, 23, 11, 59, 59)));
        lista.add(new Atividade("Lista de Estatistica", LocalDateTime.of(2026, 10, 25, 23, 59, 59)));
        lista.add(new Atividade("Recuperacao de Algebra Linear", LocalDateTime.of(2026, 10, 22, 12, 00, 00)));
        lista.add(new Atividade("Projeto Integrador", LocalDateTime.now().plusDays(2))); // sempre va constar daqui 2 dias

        lista.get(1).setDataEntrega(lista.get(1).getDataEntrega().plusDays(5)); //adiar lista de estatistica 

        lista.sort(Comparator.comparing(Atividade::getDataEntrega));

        System.out.println("Prazos");
        for (Atividade ativ : lista) {
            System.out.println("Descriçao: " + ativ.getDescricao());
            System.out.println("Entrega: " + ativ.getDataEntrega().format(fmt));
            System.out.println("Dias Restantes: " + ativ.getDiasRestantes());
            System.out.println("Status: " + ativ.getStatus());
            System.out.println("\n");
        }

        System.out.println("Testando validação de data...");
        try {
            LocalDateTime.parse("31/02/2026 23:59", fmt);
        } catch (DateTimeParseException e) {
            System.out.println("Sucesso no teste: Data '31/02/2026' foi rejeitada!");
        }
    }
}
