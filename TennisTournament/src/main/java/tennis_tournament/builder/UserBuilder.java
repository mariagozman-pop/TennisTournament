package tennis_tournament.builder;

import tennis_tournament.model.User;
import tennis_tournament.model.UserRole;

public abstract class UserBuilder<T extends UserBuilder<T>> {
    public String username;
    public String email;
    public String password;
    public UserRole role;

    public T username(String username) {
        this.username = username;
        return self();
    }

    public T email(String email) {
        this.email = email;
        return self();
    }

    public T password(String password) {
        this.password = password;
        return self();
    }

    public T role(UserRole role) {
        this.role = role;
        return self();
    }

    // Abstract method for child builders to return their type
    protected abstract T self();

    // Factory method that builds a User instance
    public abstract User build();
}