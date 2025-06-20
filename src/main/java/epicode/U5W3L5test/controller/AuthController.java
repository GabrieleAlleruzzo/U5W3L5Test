package epicode.U5W3L5test.controller;


import epicode.U5W3L5test.dto.LoginDto;
import epicode.U5W3L5test.dto.UtenteDto;
import epicode.U5W3L5test.exception.NotFoundException;
import epicode.U5W3L5test.exception.ValidationException;
import epicode.U5W3L5test.model.Utente;
import epicode.U5W3L5test.service.AuthService;
import epicode.U5W3L5test.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private UtenteService utenteService;

    @Autowired
    private AuthService authService;

    @PostMapping("/auth/register")
    public Utente register(@RequestBody @Validated UtenteDto userDto, BindingResult bindingResult) throws ValidationException {
        if (bindingResult.hasErrors()) {
            throw new ValidationException(bindingResult.getAllErrors().stream().
                    map(objectError -> objectError.getDefaultMessage()).
                    reduce("", (s, e) -> s + e));
        }

        return utenteService.saveUser(userDto);
    }
    @GetMapping("/auth/login")
    public String login(@RequestBody @Validated LoginDto loginDto, BindingResult bindingResult) throws ValidationException, NotFoundException {
        if(bindingResult.hasErrors()){
            throw new ValidationException(bindingResult.getAllErrors().stream().
                    map(objectError -> objectError.getDefaultMessage()).
                    reduce("", (s,e)->s+e));
        }

        return authService.login(loginDto);
    }
}



