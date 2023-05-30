package com.example.backend_Admin.services;

import com.example.backend_Admin.models.DTOs.GameDTO;
import com.example.backend_Admin.models.DTOs.RiderDTO;
import com.example.backend_Admin.models.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GameService {


    public List<GameDTO> getAllGamesFromAdminBackend(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:9090/userAPI/games";
        List<GameDTO> games = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<GameDTO>>() {})
                .getBody();

        return games;
    }

    public GameDTO getGameById(int id) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:9090/userAPI/games/id/"+ id;
        GameDTO game = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<GameDTO>() {})
                .getBody();

        return game;
    }



}
