package com.example.statsservice.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/stats")
public class StatsController {

    private final Map<Long, Team> teams = new HashMap<>();
    private final Map<Long, Player> players = new HashMap<>();

    public StatsController() {
        // Ajout de valeurs de test pour les équipes et les joueurs
        teams.put(1L, new Team(1L, "Team A"));
        teams.put(2L, new Team(2L, "Team B"));

        players.put(101L, new Player(101L, "John Doe"));
        players.put(102L, new Player(102L, "Jane Doe"));
    }

    @GetMapping("/team-stats/{teamId}")
    @ApiOperation(value = "Récupère les statistiques d'une équipe pour la saison.")
    public ResponseEntity<TeamStats> getTeamStats(@PathVariable Long teamId) {
        Team team = teams.get(teamId);

        if (team != null) {
            TeamStats teamStats = new TeamStats(team, 30, 20, 10);
            return new ResponseEntity<>(teamStats, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/player-stats/{playerId}")
    @ApiOperation(value = "Récupère les statistiques d'un joueur pour la saison.")
    public ResponseEntity<PlayerStats> getPlayerStats(@PathVariable Long playerId) {
        Player player = players.get(playerId);

        if (player != null) {
            PlayerStats playerStats = new PlayerStats(player, 15, 5, 10);
            return new ResponseEntity<>(playerStats, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Classe TeamStats
    public static class TeamStats {
        private Team team;
        private int wins;
        private int losses;
        private int draws;

        public TeamStats() {
        }

        public TeamStats(Team team, int wins, int losses, int draws) {
            this.team = team;
            this.wins = wins;
            this.losses = losses;
            this.draws = draws;
        }

        // Getters, setters, autres méthodes nécessaires

        public Team getTeam() {
            return team;
        }

        public void setTeam(Team team) {
            this.team = team;
        }

        public int getWins() {
            return wins;
        }

        public void setWins(int wins) {
            this.wins = wins;
        }

        public int getLosses() {
            return losses;
        }

        public void setLosses(int losses) {
            this.losses = losses;
        }

        public int getDraws() {
            return draws;
        }

        public void setDraws(int draws) {
            this.draws = draws;
        }
    }

    // Classe PlayerStats
    public static class PlayerStats {
        private Player player;
        private int goalsScored;
        private int assists;
        private int yellowCards;

        public PlayerStats() {
        }

        public PlayerStats(Player player, int goalsScored, int assists, int yellowCards) {
            this.player = player;
            this.goalsScored = goalsScored;
            this.assists = assists;
            this.yellowCards = yellowCards;
        }

        // Getters, setters, autres méthodes nécessaires

        public Player getPlayer() {
            return player;
        }

        public void setPlayer(Player player) {
            this.player = player;
        }

        public int getGoalsScored() {
            return goalsScored;
        }

        public void setGoalsScored(int goalsScored) {
            this.goalsScored = goalsScored;
        }

        public int getAssists() {
            return assists;
        }

        public void setAssists(int assists) {
            this.assists = assists;
        }

        public int getYellowCards() {
            return yellowCards;
        }

        public void setYellowCards(int yellowCards) {
            this.yellowCards = yellowCards;
        }
    }

    // Classe Team
    public static class Team {
        private Long id;
        private String name;

        public Team() {
        }

        public Team(Long id, String name) {
            this.id = id;
            this.name = name;
        }

        // Getters, setters, autres méthodes nécessaires

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    // Classe Player
    public static class Player {
        private Long id;
        private String name;

        public Player() {
        }

        public Player(Long id, String name) {
            this.id = id;
            this.name = name;
        }

        // Getters, setters, autres méthodes nécessaires

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
