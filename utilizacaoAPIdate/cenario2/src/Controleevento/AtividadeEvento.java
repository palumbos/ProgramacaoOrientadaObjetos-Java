package Controleevento;

import java.time.Duration;
import java.time.LocalDateTime;

public class AtividadeEvento {
    private String titulo;
    private LocalDateTime inicio;
    private LocalDateTime termino;
    private LocalDateTime prazoInscricao;

    public AtividadeEvento(String titulo, LocalDateTime inicio, LocalDateTime termino, LocalDateTime prazoInscricao) {
        this.titulo = titulo;
        this.inicio = inicio;
        this.termino = termino;
        this.prazoInscricao = prazoInscricao;
    }

    public String getTitulo() { return titulo; }
    public LocalDateTime getInicio() { return inicio; }
    public LocalDateTime getTermino() { return termino; }
    public LocalDateTime getPrazoInscricao() { return prazoInscricao; }

    public void reagendar(LocalDateTime novoInicio, LocalDateTime novoTermino) {
        this.inicio = novoInicio;
        this.termino = novoTermino;
    }

    public Duration getDuracao() {
        return Duration.between(inicio, termino);
    }

    public boolean isInscricaoAberta() {
        LocalDateTime agora = LocalDateTime.now();
        return agora.isBefore(prazoInscricao);
    }

    public boolean temConflitoCom(AtividadeEvento outra) {
        return this.inicio.isBefore(outra.getTermino()) && this.termino.isAfter(outra.getInicio());
    }
}
