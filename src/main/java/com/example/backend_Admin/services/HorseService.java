package com.example.backend_Admin.services;

import com.example.backend_Admin.models.DTOs.HorseDTO;
import com.example.backend_Admin.models.DTOs.RiderDTO;
import com.example.backend_Admin.models.Horse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class HorseService{

    public boolean createHorse(HorseDTO horseDTO){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:9090/api/addHorse";
        ResponseEntity<Boolean> response = restTemplate.postForEntity(url, horseDTO, Boolean.class);
        return response.getBody();
    }

    public List<HorseDTO> getAllHorses(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:9090/api/horses";
        List<HorseDTO> horses = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<HorseDTO>>() {})
                .getBody();

        return horses;
    }

    public HorseDTO getHorseById(int id){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:9090/api/horse/"+ id;
        HorseDTO horse = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<HorseDTO>() {})
                .getBody();

        return horse;
    }

    public HorseDTO getHorseByName(String name){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:9090/api/horseName/"+ name;
        HorseDTO horse = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<HorseDTO>() {})
                .getBody();

        return horse;
    }

}
