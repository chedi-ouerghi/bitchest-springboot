package tn.springboot.bitshest.services.Auth;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tn.springboot.bitshest.entity.Login;
import tn.springboot.bitshest.repository.LoginRepository;
import tn.springboot.bitshest.util.JwtUtil;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Service
public class AuthService {

    private final LoginRepository loginRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @PersistenceContext
    private EntityManager entityManager;

    public AuthService(LoginRepository loginRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.loginRepository = loginRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    @Scheduled(fixedRate = 3600000)
    public void clearTokenEveryHour() {
        loginRepository.clearTokens();
        System.out.println("Tokens ont été réinitialisés pour tous les utilisateurs.");
    }

    @Transactional
    public String register(String nom, String email, String password, String role) {

        String hashedPassword = passwordEncoder.encode(password);

        entityManager.createNativeQuery("CALL LoginProcedure(:email, :nom, :role, :password)")
                .setParameter("email", email)
                .setParameter("nom", nom)
                .setParameter("role", role)
                .setParameter("password", hashedPassword)
                .executeUpdate();

        return "Inscription réussie avec succès !";
    }

    public String login(String email, String password) {
        Login login = loginRepository.findByEmail(email);

        if (login == null || !passwordEncoder.matches(password, login.getPassword())) {
            throw new RuntimeException("Email ou mot de passe incorrect !");
        }

        // Génération du token JWT après une connexion réussie
        String token = jwtUtil.generateToken(email, login.getRole().name());

        // Mettre à jour l'entité avec le token généré
        login.setToken(token);
        loginRepository.save(login);

        return token;
    }

}
