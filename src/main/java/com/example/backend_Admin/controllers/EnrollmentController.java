package com.example.backend_Admin.controllers;

import com.example.backend_Admin.models.DTOs.EnrollmentDTO;
import com.example.backend_Admin.services.EnrollmentService;
import com.example.backend_Admin.services.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/userAPI")
public class EnrollmentController {
    @Autowired
    private EnrollmentService enrollmentService;
    @Autowired
    private ValidationService validationService;

    @GetMapping("/enrollments")
    public ResponseEntity<List<EnrollmentDTO>> getAllEnrollments(){
        List<EnrollmentDTO> enrollmentDTOS = enrollmentService.getAllEnrollments();
        return ResponseEntity.ok(enrollmentDTOS);
    }

    @GetMapping("/enrollments/user/{id}")
    public ResponseEntity<List<EnrollmentDTO>> getEnrollmentsByRiderId(@PathVariable int id){
        List<EnrollmentDTO> enrollmentDTOS = enrollmentService.getAllEnrollmentsByRiderId(id);
        return ResponseEntity.ok(enrollmentDTOS);
    }

    @PostMapping("/enrollments")
    public boolean addEnrollment(@RequestBody EnrollmentDTO enrollmentDTO){
        boolean valid1 = false;
        boolean valid2 = false;

        valid1 = validationService.riderValidator(enrollmentDTO.getRider());
        valid2 = validationService.gameValidator(enrollmentDTO.getGame());

        boolean valid = false;
        if(valid1 && valid2){
            valid = enrollmentService.addEnrollment(enrollmentDTO);
        }

        return valid;
    }


    @PutMapping("/enrollments")
    public boolean updateEnrollment(@RequestBody EnrollmentDTO enrollmentDTO){
        boolean valid1 = false;
        boolean valid2 = false;
        boolean valid3 = false;

        valid1 = validationService.riderValidator(enrollmentDTO.getRider());
        valid2 = validationService.gameValidator(enrollmentDTO.getGame());
        valid3 = validationService.intValidator(enrollmentDTO.getId(), 0);

        boolean valid = false;
        if(valid1 && valid2 && valid3){
            valid = enrollmentService.updateEnrollment(enrollmentDTO);
        }

        return valid;
    }

    @DeleteMapping("/enrollment/{id}")
    public String deleteEnrollmentById(@PathVariable int id){
        boolean valid = false;
        valid = validationService.intValidator(id, 0);

        if(valid){
            return enrollmentService.deleteEnrollmentById(id);
        }

        return "Enrollment not deleted.";
    }
}
