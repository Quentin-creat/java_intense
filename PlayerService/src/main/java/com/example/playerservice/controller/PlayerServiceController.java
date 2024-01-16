package com.example.playerservice.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@Api(tags = "Player API", description = "Operations related to players")
@RequestMapping("/player")
public class PlayerServiceController {

    private List<Player> players;

    public PlayerServiceController() {
        // Initialisation de la liste de joueurs avec des données préexistantes
        this.players = Arrays.asList(
                new Player("John Doe", "Forward"),
                new Player("Jane Doe", "Midfielder"),
                new Player("Bob Smith", "Goalkeeper")
        );
    }
    @GetMapping("/{id}")
    @ApiOperation(value = "Get player details by ID", response = Player.class)
    public Player getPlayerDetails(
            @ApiParam(value = "Player ID", required = true) @PathVariable int id) {
        return players.get(id - 1);
    }

    @PostMapping
    @ApiOperation(value = "Add a new player", response = Player.class)
    public Player addPlayer(
            @ApiParam(value = "Player details", required = true) @RequestBody Player player) {
        players.add(player);
        return player;
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update player details by ID", response = Player.class)
    public Player updatePlayer(
            @ApiParam(value = "Player ID", required = true) @PathVariable int id,
            @ApiParam(value = "Updated player details", required = true) @RequestBody Player updatedPlayer) {
        Player existingPlayer = players.get(id - 1);
        existingPlayer.setName(updatedPlayer.getName());
        existingPlayer.setPosition(updatedPlayer.getPosition());
        // Mettez à jour d'autres propriétés au besoin
        return existingPlayer;
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete player by ID")
    public void deletePlayer(
            @ApiParam(value = "Player ID", required = true) @PathVariable int id) {
        players.remove(id - 1);
    }


    public static class Player {
        private String name;
        private String position;

        public Player(String name, String position) {
            this.name = name;
            this.position = position;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }
    }
}
