package epicode.U5W3L5test.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Evento {
    @Id
    @GeneratedValue
    private int id;
    private String titolo;
    private String descrizione;
    private LocalDate dataEvento;
    private String luogo;
    private int postiTotali;
    private int postiDisponibili;

    @ManyToOne
    @JoinColumn(name = "organizer_id")
    private Utente organizer;

    @OneToMany(mappedBy = "evento", cascade = CascadeType.ALL)
    private List<Prenotazione> prenotazione;
}
