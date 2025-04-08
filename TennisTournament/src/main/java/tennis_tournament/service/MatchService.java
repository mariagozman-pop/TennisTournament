package tennis_tournament.service;

import tennis_tournament.model.Match;
import tennis_tournament.model.Tournament;
import tennis_tournament.model.Player;
import tennis_tournament.model.Referee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tennis_tournament.repository.MatchRepository;

import java.time.LocalDateTime;

@Service
public class MatchService {

    @Autowired
    private MatchRepository matchRepository;

    public Match createMatch(Tournament tournament, Player player1, Player player2, Referee referee, LocalDateTime matchDate) {
        Match match = new Match();
        match.setTournament(tournament);
        match.setPlayer1(player1);
        match.setPlayer2(player2);
        match.setReferee(referee);
        match.setMatchDate(matchDate);
        return matchRepository.save(match);
    }

    public Match getMatchById(Long id) {
        return matchRepository.findById(id).orElseThrow(() -> new RuntimeException("Match not found"));
    }
}