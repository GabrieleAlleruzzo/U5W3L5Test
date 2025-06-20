package epicode.U5W3L5test.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Entity
public class Prenotazione {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Evento evento;

    private LocalDateTime datatPrenotazione;
}
