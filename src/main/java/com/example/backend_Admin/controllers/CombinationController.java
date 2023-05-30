package com.example.backend_Admin.controllers;

import com.example.backend_Admin.models.DTOs.CombinationDTO;
import com.example.backend_Admin.services.CombinationService;
import com.example.backend_Admin.models.Combination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/userAPI")
public class CombinationController {
    @Autowired
    private CombinationService combinationService;

    @GetMapping("/combinations")
    public List<CombinationDTO> getAllCombination(){ return combinationService.getAllCombinations(); }

    @PostMapping("/combinations")
    public boolean addCombination(@RequestBody CombinationDTO combination){ return combinationService.createCombination(combination); }

    @GetMapping("/combinations/id/{id}")
    public List<CombinationDTO> getCombinationByUserId(@PathVariable int id){
        List<CombinationDTO> cobination = combinationService.getCombinationByUserId(id);
        return cobination;
    }

    @DeleteMapping("/combinations/{id}")
    public String deleteCombinationById(@PathVariable int id){ return combinationService.deleteCombinationById(id); }
}
