package com.example.backend_Admin.services;

import com.example.backend_Admin.models.DTOs.CreateRiderDTO;
import com.example.backend_Admin.models.DTOs.EnrollmentDTO;
import com.example.backend_Admin.models.DTOs.GameDTO;
import com.example.backend_Admin.models.DTOs.RiderDTO;
import com.example.backend_Admin.models.Rider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RiderService {


    public List<RiderDTO> getAllRiders(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:9090/userAPI/riders";
        List<RiderDTO> riders = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<RiderDTO>>() {})
                .getBody();

        return riders;
    }

    public boolean addRider(CreateRiderDTO riderDTO) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:9090/userAPI/riders";
        ResponseEntity<Boolean> response = restTemplate.postForEntity(url, riderDTO, Boolean.class);
        return response.getBody();
    }

    public RiderDTO getRiderById(int id) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:9090/userAPI/riders/id/"+ id;
        RiderDTO rider = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<RiderDTO>() {})
                .getBody();

        return rider;
    }

    public RiderDTO getRiderByName(String name) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:9090/userAPI/riders/name/"+ name;
        RiderDTO rider = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<RiderDTO>() {})
                .getBody();

        return rider;
    }


    public boolean updateRider (RiderDTO riderDTO)
    {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:9090/userAPI/riders" ;
        ResponseEntity<Boolean> response = restTemplate.exchange(
                url,
                HttpMethod.PUT,
                new HttpEntity<>(riderDTO),
                Boolean.class);
        return response.getBody();
    }

    public String deleteRiderById(int id){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:9090/userAPI/riders/" + id;
        ResponseEntity<String> response = restTemplate.exchange(
                url,
                HttpMethod.DELETE,
                null,
                String.class);
        return response.getBody();
    }

}
