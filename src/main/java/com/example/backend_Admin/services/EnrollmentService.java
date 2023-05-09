package com.example.backend_Admin.services;

import com.example.backend_Admin.models.DTOs.EnrollmentDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
public class EnrollmentService {

    public boolean addEnrollment(EnrollmentDTO enrollmentDTO){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:9090/api/addEnrollment";
        ResponseEntity<Boolean> response = restTemplate.postForEntity(url, enrollmentDTO, Boolean.class);
        return response.getBody();

    }

    public List<EnrollmentDTO> getAllEnrollmentsByRiderId(int id){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:9090/api/enrollments/user/"+ id;
        List<EnrollmentDTO> enrollments = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<EnrollmentDTO>>() {})
                .getBody();

        return enrollments;
    }

    public List<EnrollmentDTO> getAllEnrollments(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:9090/api/enrollments ";
        List<EnrollmentDTO> enrollments = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<EnrollmentDTO>>() {})
                .getBody();

        return enrollments;
    }


    public boolean updateEnrollment(EnrollmentDTO enrollmentDTO){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:9090/api/updateEnrollment";
        ResponseEntity<Boolean> response = restTemplate.exchange(
                url,
                HttpMethod.PUT,
                new HttpEntity<>(enrollmentDTO),
                Boolean.class);
        return response.getBody();
    }

    public String deleteEnrollmentById(int id){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:9090/api/deleteEnrollment/" + id;
        ResponseEntity<String> response = restTemplate.exchange(
                url,
                HttpMethod.DELETE,
                null,
                String.class);
        return response.getBody();
    }
}
