package tennis_tournament.controller;

import tennis_tournament.model.Tournament;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tennis_tournament.service.TournamentService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/tournaments")
public class TournamentController {

    @Autowired
    private TournamentService tournamentService;

    @PostMapping("/create")
    public Tournament createTournament(@RequestParam String name,
                                       @RequestParam String location,
                                       @RequestParam String startDate,
                                       @RequestParam String endDate) {
        return tournamentService.createTournament(name, location, LocalDate.parse(startDate), LocalDate.parse(endDate));
    }

    @GetMapping("/{id}")
    public Tournament getTournamentById(@PathVariable Long id) {
        return tournamentService.getTournamentById(id);
    }

    @GetMapping("/")
    public List<Tournament> getAllTournaments() {
        return tournamentService.getAllTournaments();
    }
}