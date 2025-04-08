package tennis_tournament.model;

import tennis_tournament.builder.UserBuilder;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("PLAYER")
public class Player extends User {

    public Player() {}

    private Player(PlayerBuilder builder) {
        super(builder);
    }

    // Player's specific builder
    public static class PlayerBuilder extends UserBuilder<PlayerBuilder> {

        @Override
        protected PlayerBuilder self() {
            return this;
        }

        @Override
        public Player build() {
            return new Player(this);
        }
    }
}