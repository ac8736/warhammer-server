package dev.warhammer.celestial_orrery.user;

import dev.warhammer.celestial_orrery.jwt.JwtTokenProvider;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        Map<String, String> response = new HashMap<>();
        if (!userService.createUser(user)) {
            response.put("error", "This user already exists.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        response.put("token", JwtTokenProvider.generateToken(user.getUsername()));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<?> usernameLogin(@RequestBody User user) {
        boolean valid = userService.validateLogin(user);
        if (!valid) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        Map<String, String> response = new HashMap<>();
        response.put("token", JwtTokenProvider.generateToken(user.getUsername()));
        return ResponseEntity.ok(response);
    }

}
