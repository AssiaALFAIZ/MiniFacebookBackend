package com.facebook.minifacebookback.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Data
@NoArgsConstructor @AllArgsConstructor
@Entity
public class Commentaire {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_commentaire;
    @Column
    private String text;
    @Column
    private Date date;
    @Column
    private Long id_utilisateur;
    @Column
    private Long id_poste;

}
