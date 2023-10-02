package com.facebook.minifacebookback.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.Date;
@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_utilisateur;
    @Column(name = "nom")
    private String nom;
    @Column
    private  String prenom;
    @Column
    private Date date_naissance;
    @Column
    private String ville;
    @Column
    private String adresse;
    @Column
    private String email;
    @Column
    private String password;
}
