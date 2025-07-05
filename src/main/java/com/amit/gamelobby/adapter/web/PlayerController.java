package com.amit.gamelobby.adapter.web;

import com.amit.gamelobby.application.port.in.PlayerUseCase;
import com.amit.gamelobby.domain.model.Player;
import com.amit.gamelobby.dto.CreatePlayer;
import com.amit.gamelobby.dto.PlayerResponse;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/players")
public class PlayerController {

    private final PlayerUseCase PlayerUseCase;

    public PlayerController(PlayerUseCase PlayerUseCase) {
        this.PlayerUseCase = PlayerUseCase;
    }

    @PostMapping
    public ResponseEntity<PlayerResponse> createPlayer(
        @RequestBody CreatePlayer request
    ) {
        Player Player = PlayerUseCase.createPlayer(
            request.getPlayerName(),
            request.getEmail(),
            request.getPassword()
        );
        return ResponseEntity.ok(PlayerResponse.fromDomain(Player));
    }

    @GetMapping
    public ResponseEntity<List<PlayerResponse>> getAllLobbies() {
        List<PlayerResponse> lobbies = PlayerUseCase.getAllLobbies()
            .stream()
            .map(PlayerResponse::fromDomain)
            .collect(Collectors.toList());
        return ResponseEntity.ok(lobbies);
    }

    @GetMapping("/{PlayerId}")
    public ResponseEntity<PlayerResponse> getPlayer(
        @PathVariable UUID PlayerId
    ) {
        return PlayerUseCase.getPlayerById(PlayerId)
            .map(PlayerResponse::fromDomain)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping
    public ResponseEntity<String> deletePlayer(@PathVariable UUID PlayerId) {
        PlayerUseCase.deleteById(PlayerId);
        return new ResponseEntity<String>("Player Deleted", HttpStatus.OK);
    }
}
