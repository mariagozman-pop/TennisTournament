CREATE TABLE users (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role ENUM('PLAYER', 'REFEREE', 'ADMIN') NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE tournaments (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    location VARCHAR(100) NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE matches (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    tournament_id BIGINT NOT NULL,
    player1_id BIGINT NOT NULL,
    player2_id BIGINT NOT NULL,
    referee_id BIGINT NOT NULL,
    match_date TIMESTAMP NOT NULL,
    score VARCHAR(20) DEFAULT NULL,
    FOREIGN KEY (tournament_id) REFERENCES tournaments(id) ON DELETE CASCADE,
    FOREIGN KEY (player1_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (player2_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (referee_id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE match_scores (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    match_id BIGINT NOT NULL,
    referee_id BIGINT NOT NULL,
    player1_score INT CHECK (player1_score >= 0),
    player2_score INT CHECK (player2_score >= 0),
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (match_id) REFERENCES matches(id) ON DELETE CASCADE,
    FOREIGN KEY (referee_id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE tournament_players (
    tournament_id BIGINT NOT NULL,
    player_id BIGINT NOT NULL,
    PRIMARY KEY (tournament_id, player_id),
    FOREIGN KEY (tournament_id) REFERENCES tournaments(id),
    FOREIGN KEY (player_id) REFERENCES users(id)
);

ALTER TABLE matches
ADD CONSTRAINT FK_player1 FOREIGN KEY (player1_id) REFERENCES users(id) ON DELETE CASCADE;

ALTER TABLE matches
ADD CONSTRAINT FK_player2 FOREIGN KEY (player2_id) REFERENCES users(id) ON DELETE CASCADE;

ALTER TABLE tournament_players
    ADD CONSTRAINT FK_player FOREIGN KEY (player_id) REFERENCES users(id) ON DELETE CASCADE;






