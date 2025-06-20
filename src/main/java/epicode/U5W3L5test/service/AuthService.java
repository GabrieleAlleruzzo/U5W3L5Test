package epicode.U5W3L5test.service;


import epicode.U5W3L5test.dto.LoginDto;
import epicode.U5W3L5test.exception.NotFoundException;
import epicode.U5W3L5test.model.Utente;
import epicode.U5W3L5test.repository.UtenteRepository;
import epicode.U5W3L5test.security.JwtTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UtenteRepository utenteRepository;

    @Autowired
    private JwtTool jwtTool;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String login(LoginDto loginDto) throws NotFoundException {
        Utente user = utenteRepository.findByUsername(loginDto.getUsername()).
                orElseThrow(() -> new NotFoundException("Utente con questo username/password non trovato"));

        if(passwordEncoder.matches(loginDto.getPassword(), user.getPassword())){
            //utente è autenticato, devo creare il token
            return jwtTool.createToken(user);
        }
        else{
            throw new NotFoundException("Utente con questo username/password non trovato");
        }
    }
}

