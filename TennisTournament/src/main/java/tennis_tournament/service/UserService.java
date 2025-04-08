package tennis_tournament.service;

import tennis_tournament.builder.UserBuilder;
import tennis_tournament.model.User;
import tennis_tournament.model.Referee;
import tennis_tournament.model.Player;
import tennis_tournament.model.Admin;
import tennis_tournament.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tennis_tournament.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(String username, String email, String password, String role) {
        UserBuilder<?> builder;

        // Use the builder pattern based on the role passed
        switch (role.toUpperCase()) {
            case "REFEREE":
                builder = new Referee.RefereeBuilder();
                break;
            case "PLAYER":
                builder = new Player.PlayerBuilder();
                break;
            case "ADMIN":
                builder = new Admin.AdminBuilder();
                break;
            default:
                throw new IllegalArgumentException("Invalid role: " + role);
        }

        // Set properties using builder
        builder.username(username)
                .email(email)
                .password(password)
                .role(UserRole.valueOf(role.toUpperCase()));

        // Build the user and save it
        User user = builder.build();

        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public List<User> findByRole(UserRole role) {
        return userRepository.findByRole(role);
    }
}