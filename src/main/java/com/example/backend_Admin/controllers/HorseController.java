package com.example.backend_Admin.controllers;

import com.example.backend_Admin.models.DTOs.HorseDTO;
import com.example.backend_Admin.services.HorseService;
import com.example.backend_Admin.models.Horse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/userAPI")
public class HorseController {
    @Autowired
    private HorseService horseService;

    @GetMapping("/horses")
    public List<HorseDTO> getAllHorses(){ return horseService.getAllHorses(); }

    @PostMapping("/horses")
    public boolean addHorse(@RequestBody HorseDTO horse){ return horseService.createHorse(horse); }

    @GetMapping("/horses/id/{id}")
    public HorseDTO getHorseById(@PathVariable int id){ return horseService.getHorseById(id); }

    @GetMapping("/horses/name/{name}")
    public HorseDTO getHorseByName(@PathVariable String name){ return horseService.getHorseByName(name); }

}
