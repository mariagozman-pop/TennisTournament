package tennis_tournament.model;

import tennis_tournament.builder.UserBuilder;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("ADMIN")
public class Admin extends User {

    public Admin() {}

    private Admin(AdminBuilder builder) {
        super(builder);
    }

    public static class AdminBuilder extends UserBuilder<AdminBuilder> {

        @Override
        protected AdminBuilder self() {
            return this;
        }

        @Override
        public Admin build() {
            return new Admin(this);
        }
    }
}
