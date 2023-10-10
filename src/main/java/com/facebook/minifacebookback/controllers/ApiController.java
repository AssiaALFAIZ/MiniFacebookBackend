package com.facebook.minifacebookback.controllers;

import com.facebook.minifacebookback.dto.UserData;
import com.facebook.minifacebookback.entities.Utilisateur;
import com.facebook.minifacebookback.repositories.UtilisateurRepository;
import com.facebook.minifacebookback.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {
    private UtilisateurRepository utilisateurRepository;
    private UserService userService;
    public ApiController(UtilisateurRepository utilisateurRepository, UserService userService){
        this.utilisateurRepository=utilisateurRepository;
        this.userService=userService;

    }
    @GetMapping("/utilisateurs")
    public List<Utilisateur> getUsers() {
        return utilisateurRepository.findAll();
    }
    @PostMapping("/Infos")
    public ResponseEntity<String> info(@ModelAttribute UserData userData) {

        if(!userData.equals(null)){
            String given_name = userData.getGiven_name();
            String family_name = userData.getFamily_name();
            String email = userData.getEmail();
            String preferred_username = userData.getPreferred_username();
            System.out.println("given_name: " + given_name);
            System.out.println("family_name: " + family_name);
            System.out.println("email: " + email);
            System.out.println("preferred_username: " + preferred_username);
            userService.saveUtilisateur(userData);
            return ResponseEntity.ok("User Received Successfully");
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("NOT Received");
        }

    }

}
