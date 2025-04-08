package tennis_tournament;

import tennis_tournament.model.User;
import tennis_tournament.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tennis_tournament.service.UserService;

import java.util.List;

@SpringBootApplication
public class TennisTournament implements CommandLineRunner {

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(TennisTournament.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Fetch all players and print them
        List<User> players = userService.findByRole(UserRole.PLAYER);

        System.out.println("All players in the database:");
        for (User player : players) {
            System.out.println("Username: " + player.getUsername() + ", Email: " + player.getEmail());
        }
    }
}
