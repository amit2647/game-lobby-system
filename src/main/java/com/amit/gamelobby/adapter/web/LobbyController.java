package com.amit.gamelobby.adapter.web;

import com.amit.gamelobby.application.port.in.LobbyUseCase;
import com.amit.gamelobby.domain.model.Lobby;
import com.amit.gamelobby.dto.CreateLobby;
import com.amit.gamelobby.dto.LobbyResponse;
import com.amit.gamelobby.dto.PlayerAction;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/lobbies")
public class LobbyController {

    private final LobbyUseCase lobbyUseCase;

    public LobbyController(LobbyUseCase lobbyUseCase) {
        this.lobbyUseCase = lobbyUseCase;
    }

    @PostMapping
    public ResponseEntity<LobbyResponse> createLobby(
        @RequestBody CreateLobby request
    ) {
        Lobby lobby = lobbyUseCase.createLobby(
            request.getName(),
            request.getMaxPlayers()
        );
        return ResponseEntity.ok(LobbyResponse.fromDomain(lobby));
    }

    @PostMapping("/{lobbyId}/join")
    public ResponseEntity<LobbyResponse> joinLobby(
        @PathVariable UUID lobbyId,
        @RequestBody PlayerAction request
    ) {
        return lobbyUseCase
            .joinLobby(lobbyId, request.getPlayer())
            .map(LobbyResponse::fromDomain)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{lobbyId}/leave")
    public ResponseEntity<LobbyResponse> leaveLobby(
        @PathVariable UUID lobbyId,
        @RequestBody PlayerAction request
    ) {
        return lobbyUseCase
            .leaveLobby(lobbyId, request.getPlayer())
            .map(LobbyResponse::fromDomain)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<LobbyResponse>> getAllLobbies() {
        List<LobbyResponse> lobbies = lobbyUseCase
            .getAllLobbies()
            .stream()
            .map(LobbyResponse::fromDomain)
            .collect(Collectors.toList());
        return ResponseEntity.ok(lobbies);
    }

    @GetMapping("/{lobbyId}")
    public ResponseEntity<LobbyResponse> getLobby(@PathVariable UUID lobbyId) {
        return lobbyUseCase
            .getLobbyById(lobbyId)
            .map(LobbyResponse::fromDomain)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping
    public ResponseEntity<String> deleleLobby(@PathVariable UUID lobbyId) {
        lobbyUseCase.deleteById(lobbyId);
        return new ResponseEntity<String>("Lobby deleted", HttpStatus.OK);
    }
}
