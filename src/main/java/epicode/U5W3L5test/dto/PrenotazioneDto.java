package epicode.U5W3L5test.dto;



import epicode.U5W3L5test.model.Evento;
import epicode.U5W3L5test.model.Utente;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrenotazioneDto {
    @NotEmpty(message = "il nome non può essere vuoto")
    private Utente utente;
    @NotEmpty(message = "l'evento non può essere vuoto")
    private Evento evento;
    @NotEmpty(message = "la data non può essere vuoto")
    private LocalDateTime datatPrenotazione;
}
