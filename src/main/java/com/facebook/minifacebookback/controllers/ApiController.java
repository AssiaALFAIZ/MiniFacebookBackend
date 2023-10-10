package com.facebook.minifacebookback.controllers;

import com.facebook.minifacebookback.entities.Utilisateur;
import com.facebook.minifacebookback.repositories.UtilisateurRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {
    private UtilisateurRepository utilisateurRepository;
    public ApiController(UtilisateurRepository utilisateurRepository){
        this.utilisateurRepository=utilisateurRepository;
    }
    @GetMapping("/utilisateurs")
    public List<Utilisateur> getUsers() {
        return utilisateurRepository.findAll();
    }
}
