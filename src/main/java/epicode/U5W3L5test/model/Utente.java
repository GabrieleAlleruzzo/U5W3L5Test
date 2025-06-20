package epicode.U5W3L5test.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import epicode.U5W3L5test.enumeration.Ruolo;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Entity(name = "users")
public class Utente implements UserDetails {
    @Id
    @GeneratedValue
    private int id;
    private String username;
    private String email;
    @JsonIgnore
    private String password;
    @Enumerated(EnumType.STRING)
    private Ruolo ruolo;

    // Relazioni
    @OneToMany(mappedBy = "organizer")
    private List<Evento> createdEvents;

    @OneToMany(mappedBy = "utente")
    private List<Prenotazione> prenotazione;

    //questo metodo ritorna tutti i ruoli che l'utente ha
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(ruolo.name()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}
