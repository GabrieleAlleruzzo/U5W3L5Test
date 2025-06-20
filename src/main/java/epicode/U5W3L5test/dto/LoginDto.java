package epicode.U5W3L5test.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {

        @NotEmpty(message = "lo username non può essere vuoto")
        private String username;
        @NotEmpty(message = "la password non può essere vuota")
        private String password;
    }
