package com.facebook.minifacebookback.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Poste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_poste;
    @Column
    private Date date_poste;
    @Column
    private String text;
    @Column
    private String image;
    @Column
    private Long id_utilisateur;
}
