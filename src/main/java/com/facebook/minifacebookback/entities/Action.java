package com.facebook.minifacebookback.entities;

import com.facebook.minifacebookback.enums.ActionEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Action {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_action;
    @Column(name = "action")
    private ActionEnum actionEnum;
    @Column
    private Long id_poste;
    @Column
    private Long id_utilisateur;
}
