package epicode.U5W3L5test.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UtenteDto {
    @NotEmpty(message = "il nome non può essere vuoto")
    private String username;
    @NotEmpty(message = "l'email non può essere vuoto")
    private String email;
    @NotEmpty(message = "la password non può essere vuoto")
    private String password;
    @NotEmpty(message = "il ruolo non può essere vuoto")
    private String ruolo;

}
