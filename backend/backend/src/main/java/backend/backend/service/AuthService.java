package backend.backend.service;

import backend.backend.dto.AuthResponse;
import backend.backend.dto.LoginRequest;
import backend.backend.dto.SignupRequest;
import backend.backend.entity.User;
import backend.backend.repository.UserRepository;
import backend.backend.security.JwtService;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final CustomUserDetailsService userDetailsService;
    private final JwtService jwtService;

    public AuthService(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            CustomUserDetailsService userDetailsService,
            JwtService jwtService
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
        this.jwtService = jwtService;
    }

    public AuthResponse signup(SignupRequest request) {

        String email = request.getEmail()
                .trim()
                .toLowerCase();

        if (userRepository.existsByEmail(email)) {
            throw new RuntimeException(
                    "Account already exists with this email."
            );
        }

        String encodedPassword = passwordEncoder.encode(
                request.getPassword()
        );

        User user = new User(
                request.getName().trim(),
                email,
                encodedPassword,
                User.Role.STUDENT
        );

        User savedUser = userRepository.save(user);

        UserDetails userDetails =
                userDetailsService.loadUserByUsername(
                        savedUser.getEmail()
                );

        String token = jwtService.generateToken(userDetails);

        return new AuthResponse(
                token,
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getEmail(),
                savedUser.getRole().name()
        );
    }

    public AuthResponse login(LoginRequest request) {

        String email = request.getEmail()
                .trim()
                .toLowerCase();

        User user = userRepository
                .findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Invalid email or password."
                        )
                );

        boolean passwordMatches = passwordEncoder.matches(
                request.getPassword(),
                user.getPassword()
        );

        if (!passwordMatches) {
            throw new RuntimeException(
                    "Invalid email or password."
            );
        }

        UserDetails userDetails =
                userDetailsService.loadUserByUsername(email);

        String token = jwtService.generateToken(userDetails);

        return new AuthResponse(
                token,
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole().name()
        );
    }
}