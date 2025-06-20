package epicode.U5W3L5test.service;


import epicode.U5W3L5test.dto.UtenteDto;
import epicode.U5W3L5test.enumeration.Ruolo;
import epicode.U5W3L5test.exception.NotFoundException;
import epicode.U5W3L5test.model.Utente;
import epicode.U5W3L5test.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UtenteService {

    @Autowired
    private UtenteRepository utenteRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Utente getUtente(int id) {
        return utenteRepository.findById(id).orElseThrow(() -> new NotFoundException("User con id " + id + " non trovato"));
    }

    public Utente saveUser(UtenteDto userDto) {
        Utente user = new Utente();
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setRuolo(Ruolo.valueOf(userDto.getRuolo()));
        utenteRepository.save(user);
        return user;
    }


}
