package com.example.matchservice.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Api(tags = "Match Controller", description = "Endpoints for managing matches")
public class MatchController {

    private List<Match> matchList = this.createSampleMatches();

    @ApiOperation("Get details of a match by ID")
    @GetMapping("/{id}")
    public Match getMatchById(@PathVariable Long id) {
        // Your logic to retrieve and return a match by ID...
        return matchList.stream()
                .filter(match -> match.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @ApiOperation("Add a new match")
    @PostMapping
    public void addMatch(@RequestBody Match match) {
        // Your logic to add a new match...
        matchList.add(match);
    }

    @ApiOperation("Update information of an existing match by ID")
    @PutMapping("/{id}")
    public void updateMatch(@PathVariable Long id, @RequestBody Match updatedMatch) {
        // Your logic to update an existing match...
        matchList.stream()
                .filter(match -> match.getId().equals(id))
                .findFirst()
                .ifPresent(match -> {
                    match.setTeam1(updatedMatch.getTeam1());
                    match.setTeam2(updatedMatch.getTeam2());
                    // Update other properties as needed
                });
    }

    @ApiOperation("Delete a match by ID")
    @DeleteMapping("/{id}")
    public void deleteMatch(@PathVariable Long id) {
        // Your logic to delete a match...
        matchList.removeIf(match -> match.getId().equals(id));
    }

    @ApiOperation("Get a list of all matches")
    @GetMapping("/list")
    public List<Match> getAllMatches() {
        // Your logic to return the entire matchList...
        return matchList;
    }

    // Additional method for initializing sample matches
    private List<Match> createSampleMatches() {
        List<Match> matchList = new ArrayList<>();

        Match match1 = new Match();
        match1.setId(1L);
        match1.setTeam1("Team A");
        match1.setTeam2("Team B");
        matchList.add(match1);

        Match match2 = new Match();
        match2.setId(2L);
        match2.setTeam1("Team C");
        match2.setTeam2("Team D");
        matchList.add(match2);

        // Add more matches as needed

        return matchList;
    }

    public static class Match {
        private Long id;
        private String team1;
        private String team2;

        // Ajoutez d'autres propriétés si nécessaire

        // Constructeurs, getters, setters

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getTeam1() {
            return team1;
        }

        public void setTeam1(String team1) {
            this.team1 = team1;
        }

        public String getTeam2() {
            return team2;
        }

        public void setTeam2(String team2) {
            this.team2 = team2;
        }
    }
}
