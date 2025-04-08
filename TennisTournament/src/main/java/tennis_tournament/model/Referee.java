package tennis_tournament.model;

import tennis_tournament.builder.UserBuilder;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("REFEREE")
public class Referee extends User {

    public Referee() {}

    private Referee(RefereeBuilder builder) {
        super(builder);
    }

    // Referee's specific builder
    public static class RefereeBuilder extends UserBuilder<RefereeBuilder> {

        @Override
        protected RefereeBuilder self() {
            return this;
        }

        @Override
        public Referee build() {
            return new Referee(this);
        }
    }
}
