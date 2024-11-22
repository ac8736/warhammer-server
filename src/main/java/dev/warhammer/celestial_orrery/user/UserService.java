package dev.warhammer.celestial_orrery.user;

import jakarta.validation.Valid;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean createUser(@Valid User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            return false;
        }

        String encryptedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);
        userRepository.save(user);
        return true;
    }

    public boolean validateLogin(User user) {
        Optional<User> foundUser = userRepository.findByUsername(user.getUsername());
        if (foundUser.isEmpty()) {
            return false;
        }

        return passwordEncoder.matches(user.getPassword(), foundUser.get().getPassword());
    }

}
