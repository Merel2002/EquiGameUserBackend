package com.example.backend_Admin.controllers;

import com.example.backend_Admin.models.DTOs.CombinationDTO;
import com.example.backend_Admin.services.CombinationService;
import com.example.backend_Admin.models.Combination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/apiUser")
public class CombinationController {
    @Autowired
    private CombinationService combinationService;

    @GetMapping("/combinations")
    public List<CombinationDTO> getAllCombination(){ return combinationService.getAllCombinations(); }

    @PostMapping("/addCombinations")
    public boolean addCombination(@RequestBody CombinationDTO combination){ return combinationService.createCombination(combination); }

    @GetMapping("/combination/{id}")
    public List<CombinationDTO> getCombinationByUserId(@PathVariable int id){
        List<CombinationDTO> cobination = combinationService.getCombinationByUserId(id);
        return cobination;
    }

    @DeleteMapping("/deleteCombination/{id}")
    public String deleteCombinationById(@PathVariable int id){ return combinationService.deleteCombinationById(id); }
}
