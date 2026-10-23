
package prazosacademicos;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


class Atividade {
    private String descricao;
    private LocalDateTime dataEntrega;

    public Atividade(String descricao, LocalDateTime dataEntrega) {
        this.descricao = descricao;
        this.dataEntrega = dataEntrega;
    }

    public String getDescricao() { return descricao; }
    public LocalDateTime getDataEntrega() { return dataEntrega; }
    public void setDataEntrega(LocalDateTime dataEntrega) { this.dataEntrega = dataEntrega; }

    public long getDiasRestantes() {
        return ChronoUnit.DAYS.between(LocalDateTime.now().toLocalDate(), dataEntrega.toLocalDate());
    }

    public String getStatus() {
        LocalDateTime agora = LocalDateTime.now();
        if (dataEntrega.isBefore(agora)) {
            return "passou meu fi";
        } else if (getDiasRestantes() <= 3) {
            return "deu de procrastinar";
        } else {
            return "pode procrastinar um pouco mais";
        }
    }
}

