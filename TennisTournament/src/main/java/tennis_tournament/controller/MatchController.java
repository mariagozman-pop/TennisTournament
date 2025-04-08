package tennis_tournament.controller;

import tennis_tournament.model.Match;
import tennis_tournament.model.Tournament;
import tennis_tournament.model.Player;
import tennis_tournament.model.Referee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tennis_tournament.service.MatchService;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/matches")
public class MatchController {

    @Autowired
    private MatchService matchService;

    @PostMapping("/create")
    public Match createMatch(@RequestParam Long tournamentId,
                             @RequestParam Long player1Id,
                             @RequestParam Long player2Id,
                             @RequestParam Long refereeId,
                             @RequestParam String matchDate) {
        Tournament tournament = new Tournament();
        Player player1 = new Player();
        Player player2 = new Player();
        Referee referee = new Referee();

        tournament.setId(tournamentId);
        player1.setId(player1Id);
        player2.setId(player2Id);
        referee.setId(refereeId);

        return matchService.createMatch(tournament, player1, player2, referee, LocalDateTime.parse(matchDate));
    }
}