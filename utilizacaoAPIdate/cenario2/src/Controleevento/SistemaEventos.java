package Controleevento;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class SistemaEventos {

    public static void main(String[] args) {
        Locale ptBR = Locale.forLanguageTag("pt-BR"); // pra ficar no modelo br

        DateTimeFormatter fmtDataHora = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        DateTimeFormatter fmtExtenso = DateTimeFormatter.ofPattern("EEEE, d 'de' MMMM 'de' yyyy 'às' HH:mm", ptBR);

        List<AtividadeEvento> listaEventos = new ArrayList<>();

        System.out.println("cadastrar atividades");

        //  Oficina de desonvolvimento de jogos ex1
        AtividadeEvento ev1 = new AtividadeEvento(
                "Oficina de desonvolvimento de jogos",
                LocalDateTime.of(2026, 11, 10, 9, 0), 
                LocalDateTime.of(2026, 11, 10, 12, 0), 
                LocalDateTime.of(2026, 10, 20, 23, 59)
        );

        // Oficina de Impresora 3d ex2
        AtividadeEvento ev2 = new AtividadeEvento(
                "Oficina de Impresora 3d",
                LocalDateTime.of(2026, 11, 10, 10, 30), // Conflita propositalmente com o  primeiro evento
                LocalDateTime.of(2026, 11, 10, 12, 30),
                LocalDateTime.of(2026, 11, 05, 23, 59) // Inscricao nao incerrada
        );

        //: oficina de git e github ex3
        AtividadeEvento ev3 = new AtividadeEvento(
                "Oficina de Git e GitHub",
                LocalDateTime.of(2026, 11, 11, 14, 00),
                LocalDateTime.of(2026, 11, 11, 17, 30),
                LocalDateTime.of(2026, 11, 01, 23, 59)
        );

        listaEventos.add(ev1);
        listaEventos.add(ev2);
        listaEventos.add(ev3);

        System.out.println("\n verificação de conflitos da agenda");
        for (int i = 0; i < listaEventos.size(); i++) {
            for (int j = i + 1; j < listaEventos.size(); j++) {
                AtividadeEvento a1 = listaEventos.get(i);
                AtividadeEvento a2 = listaEventos.get(j);

                if (a1.temConflitoCom(a2)) {
                    System.out.println(" CONFLITO DETECTADO!");
                    System.out.println( a1.getTitulo() + " (" + a1.getInicio().format(fmtDataHora) + " até " + a1.getTermino().format(fmtDataHora) + ")");
                    System.out.println(a2.getTitulo() + " (" + a2.getInicio().format(fmtDataHora) + " até " + a2.getTermino().format(fmtDataHora) + ")");
                }
            }
        }
//resolver o conflito
        System.out.println("\n reagendar para resolver conflitos");
        System.out.println("Reagendando '" + ev2.getTitulo() + "' para a tarde do mesmo dia...");

        ev2.reagendar(
                LocalDateTime.of(2026, 11, 10, 14, 00),
                LocalDateTime.of(2026, 11, 10, 16, 00)
        ); // mover o evento
        System.out.println(" Novo horario definido com sucesso!");

        listaEventos.sort(Comparator.comparing(AtividadeEvento::getInicio));

        System.out.println(" programacao completa do evento");

        for (AtividadeEvento ev : listaEventos) {
            Duration d = ev.getDuracao();
            String statusInscricao = ev.isInscricaoAberta() ? " incricao abertas !!!" : " incricao incerradas!!!";

            System.out.println("Atividade: " + ev.getTitulo());
            System.out.println("Início:    " + ev.getInicio().format(fmtExtenso));
            System.out.println("Término:   " + ev.getTermino().format(fmtDataHora));
            System.out.println("Duração:   " + d.toHours() + "h " + d.toMinutesPart() + "min");
            System.out.println("Inscrição: " + statusInscricao + " (Limite: " + ev.getPrazoInscricao().format(fmtDataHora) + ")");
            System.out.println();
        }

        LocalDate dataHoje = LocalDate.now();
        LocalDate dataEvento = listaEventos.get(0).getInicio().toLocalDate();
        Period periodoAteEvento = Period.between(dataHoje, dataEvento);

        System.out.printf("Tempo restante até o início do evento: %d mês(es) e %d dia(s).%n",
                periodoAteEvento.getMonths(), periodoAteEvento.getDays());
    }
}
