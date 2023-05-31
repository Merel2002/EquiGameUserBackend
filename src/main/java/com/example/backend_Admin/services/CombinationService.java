package com.example.backend_Admin.services;

import com.example.backend_Admin.models.Combination;
import com.example.backend_Admin.models.DTOs.CombinationDTO;
import com.example.backend_Admin.models.DTOs.RiderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class CombinationService {

    public boolean createCombination(CombinationDTO combination){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:9090/adminAPI/combinations";
        ResponseEntity<Boolean> response = restTemplate.postForEntity(url, combination, Boolean.class);
        return response.getBody();
    }

    public List<CombinationDTO> getAllCombinations(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:9090/adminAPI/combinations";
        List<CombinationDTO> combinations = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<CombinationDTO>>() {})
                .getBody();

        return combinations;
    }

    public List<CombinationDTO> getCombinationByUserId(int id){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:9090/adminAPI/combinations/user/" + id;
        List<CombinationDTO> combinations = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<CombinationDTO>>() {})
                .getBody();

        return combinations;
    }


    public String deleteCombinationById(int id){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:9090/adminAPI/combinations/" + id;
        ResponseEntity<String> response = restTemplate.exchange(
                url,
                HttpMethod.DELETE,
                null,
                String.class);
        return response.getBody();
    }
}
