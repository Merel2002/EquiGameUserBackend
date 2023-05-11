package com.example.backend_Admin.controllers;

import com.example.backend_Admin.services.GameService;
import com.example.backend_Admin.services.ValidationService;
import com.example.backend_Admin.models.DTOs.GameDTO;
import com.example.backend_Admin.services.GameService;
import com.example.backend_Admin.services.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000") //dit moet naar de andere backend...
@RestController
@RequestMapping("/apiUser")
public class GameController {
    @Autowired
    private GameService gameService;
    @Autowired
    private ValidationService validationService;

    @GetMapping("/games")
    public ResponseEntity<List<GameDTO>> getAllGames(){
        List<GameDTO> gameDTOS = gameService.getAllGamesFromAdminBackend();
        return ResponseEntity.ok(gameDTOS);
    }

    @GetMapping("/gameid/{id}")
    public ResponseEntity<GameDTO> getGameById(@PathVariable int id){
        boolean valid = false;
        valid = validationService.intValidator(id, 0);

        if(valid){
            GameDTO gamedto = gameService.getGameById(id);
            return ResponseEntity.ok(gamedto);
        }
        return null;
    }
}
