package epicode.U5W3L5test.repository;


import epicode.U5W3L5test.model.Utente;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UtenteRepository  extends JpaRepository<Utente,Integer> {
    Optional<Utente> findByUsername(@NotEmpty(message = "lo username non può essere vuoto") String username);
}
