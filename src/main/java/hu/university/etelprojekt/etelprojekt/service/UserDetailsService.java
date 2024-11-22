package hu.university.etelprojekt.etelprojekt.service;

//import hu.university.etelprojekt.etelprojekt.entity.User;
import hu.university.etelprojekt.etelprojekt.repository.UserRepository;

//import java.util.Optional;

//import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;*/
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService{

    /*@Autowired
    private UserService userService;*/

    private final UserRepository userRepository;

    public UserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}