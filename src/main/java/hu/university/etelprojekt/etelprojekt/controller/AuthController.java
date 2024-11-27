package hu.university.etelprojekt.etelprojekt.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        // Authenticate user
        if ("testuser".equals(loginRequest.getUsername()) && "password".equals(loginRequest.getPassword())) {
            String token = "test-token";
            return ResponseEntity.ok(new JwtResponse("test-token"));
        } else {
            return ResponseEntity.badRequest().body("Invalid username or password");
        }
    }
}

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class LoginRequest {
    private String username;
    private String password;
}

@Getter
@AllArgsConstructor
class JwtResponse {
    private String token;
}