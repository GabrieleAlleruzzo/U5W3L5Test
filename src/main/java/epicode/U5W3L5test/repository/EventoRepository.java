package epicode.U5W3L5test.repository;


import epicode.U5W3L5test.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository  extends JpaRepository<Evento,Integer> {
}
