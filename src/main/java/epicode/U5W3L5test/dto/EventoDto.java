package epicode.U5W3L5test.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventoDto {
    @NotEmpty(message = "titolo non può essere vuoto")
    private String titolo;
    @NotEmpty(message = "descrizione non può essere vuoto")
    private String descrizione;
    @NotEmpty(message = "data non può essere vuoto")
    private LocalDate dataEvento;
    @NotEmpty(message = "luogo non può essere vuoto")
    private String luogo;
    @NotEmpty(message = "il totale dei posti non può essere vuoto")
    private int postiTotali;
    @NotEmpty(message = "i posti disponibili non può essere vuoto")
    private int postiDisponibili;
}
