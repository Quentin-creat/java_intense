package com.example.teamservice.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamController {

    private final List<Team> teamList = new ArrayList<>();

    public TeamController() {
        // Ajout de valeurs de test
        Team team1 = new Team(1L, "Team A");
        Team team2 = new Team(2L, "Team B");

        teamList.add(team1);
        teamList.add(team2);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Récupère les détails d'une équipe par son identifiant.")
    public ResponseEntity<Team> getTeamById(@PathVariable Long id) {
        // Implémentation pour récupérer une équipe par son identifiant
        Team team = teamList.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElse(null);

        return team != null
                ? new ResponseEntity<>(team, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    @ApiOperation(value = "Ajoute une nouvelle équipe.")
    public ResponseEntity<Void> addTeam(@RequestBody Team team) {
        // Implémentation pour ajouter une nouvelle équipe
        teamList.add(team);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Met à jour les informations d'une équipe existante.")
    public ResponseEntity<Void> updateTeam(@PathVariable Long id, @RequestBody Team updatedTeam) {
        // Implémentation pour mettre à jour les informations d'une équipe par son identifiant
        for (int i = 0; i < teamList.size(); i++) {
            Team team = teamList.get(i);
            if (team.getId().equals(id)) {
                teamList.set(i, updatedTeam);
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Supprime une équipe par son identifiant.")
    public ResponseEntity<Void> deleteTeam(@PathVariable Long id) {
        // Implémentation pour supprimer une équipe par son identifiant
        teamList.removeIf(team -> team.getId().equals(id));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
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
}
