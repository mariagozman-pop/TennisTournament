package tennis_tournament.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "matches")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tournament_id", nullable = false)
    private Tournament tournament;

    @ManyToOne
    @JoinColumn(name = "player1_id", nullable = false)
    private Player player1;

    @ManyToOne
    @JoinColumn(name = "player2_id", nullable = false)
    private Player player2;

    @ManyToOne
    @JoinColumn(name = "referee_id", nullable = false)
    private Referee referee;

    @Column(nullable = false)
    private LocalDateTime matchDate;

    private String score;

    public Match() {}

    // Getters & Setters
    public Long getId() { return id; }
    public Tournament getTournament() { return tournament; }
    public Player getPlayer1() { return player1; }
    public Player getPlayer2() { return player2; }
    public Referee getReferee() { return referee; }
    public LocalDateTime getMatchDate() { return matchDate; }
    public String getScore() { return score; }
    public void setScore(String score) { this.score = score; }
    public void setTournament(Tournament tournament) { this.tournament = tournament; }
    public void setPlayer1(Player player1) { this.player1 = player1; }
    public void setPlayer2(Player player2) { this.player2 = player2; }
    public void setReferee(Referee referee) { this.referee = referee; }
    public void setMatchDate(LocalDateTime matchDate) { this.matchDate = matchDate; }
}
