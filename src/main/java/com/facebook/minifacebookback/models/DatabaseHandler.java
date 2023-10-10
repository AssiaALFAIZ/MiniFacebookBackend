package com.facebook.minifacebookback.models;

import com.facebook.minifacebookback.dto.UserData;
import com.facebook.minifacebookback.entities.Utilisateur;
import com.facebook.minifacebookback.repositories.UtilisateurRepository;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import java.util.Optional;

@Component
public class DatabaseHandler {
    private UtilisateurRepository utilisateurRepository;
    public DatabaseHandler(UtilisateurRepository utilisateurRepository){
        this.utilisateurRepository=utilisateurRepository;
    }
    public void insertUser(UserData userData){
        // Vérifier si l'username existe déjà
        Optional<Utilisateur> existingUser = utilisateurRepository.findByUsername(userData.getPreferred_username());

        Utilisateur utilisateur=new Utilisateur();
        utilisateur.setId_utilisateur(null);
        utilisateur.setNom(userData.getFamily_name());
        utilisateur.setPrenom(userData.getGiven_name());
        utilisateur.setEmail(userData.getEmail());
        utilisateur.setUsername(userData.getPreferred_username());
        utilisateur.setAdresse(null);
        utilisateur.setVille(null);
        utilisateur.setDate_naissance(null);
        if (existingUser.isPresent()) {
            // L'utilisateur avec cet username existe déjà, vous pouvez gérer cela en conséquence
            System.out.println("Cet username est déjà utilisé.");
        }else {
            utilisateurRepository.save(utilisateur);
        }

    }

}
