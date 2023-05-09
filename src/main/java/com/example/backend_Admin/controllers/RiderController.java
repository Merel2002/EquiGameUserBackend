package com.example.backend_Admin.controllers;

import com.example.backend_Admin.models.DTOs.CreateRiderDTO;
import com.example.backend_Admin.services.ValidationService;
import com.example.backend_Admin.models.DTOs.RiderDTO;
import com.example.backend_Admin.services.RiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/apiUser")
public class RiderController {
    @Autowired
    private RiderService riderService;
    @Autowired
    private ValidationService validationService;


    @PostMapping("/addRider")
    public boolean addRider(@RequestBody CreateRiderDTO riderDTO){
        boolean valid1 = false;
        boolean valid2 = false;
        valid1 = validationService.stringValidator(riderDTO.getFirstname(), 1, 30);
        valid2 = validationService.stringValidator(riderDTO.getLastname(), 1, 50);

        boolean valid = false;
        if(valid1 && valid2){
            valid = riderService.addRider(riderDTO);
        }

        return valid;
    }

    @GetMapping("/rider/{id}")
    public RiderDTO getRiderById(@PathVariable int id){
        boolean valid = false;
        valid = validationService.intValidator(id, 0);

        if(valid){
            return riderService.getRiderById(id);
        }
        return null;
    }

    @GetMapping("/riderName/{name}")
    public RiderDTO getRiderByName(@PathVariable String name){
        boolean valid = false;
        valid = validationService.stringValidator(name, 0, 50);

        if(valid){
            return riderService.getRiderByName(name);
        }
        return null;
    }

    @PutMapping("/updateRider")
    public boolean updateRider(@RequestBody RiderDTO riderDTO){
        boolean valid1 = false;
        boolean valid2 = false;
        boolean valid3 = false;
        valid1 = validationService.intValidator(riderDTO.getId(), 0);
        valid2 = validationService.stringValidator(riderDTO.getFirstname(), 1, 30);
        valid3 = validationService.stringValidator(riderDTO.getLastname(), 1, 50);

        boolean valid = false;
        if(valid1 && valid2 && valid3){
            valid = riderService.updateRider(riderDTO);
        }

        return valid;
    }

    @DeleteMapping("/deleteRider/{id}")
    public String deleteRiderById(@PathVariable int id){
        boolean valid = false;
        valid = validationService.intValidator(id, 0);

        if(valid){
            return riderService.deleteRiderById(id);
        }
        return "Rider didn't got deleted.";
    }
}
