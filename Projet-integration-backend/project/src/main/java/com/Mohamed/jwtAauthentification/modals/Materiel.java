package com.Mohamed.jwtAauthentification.modals;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Materiel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nom;

    private String type;

    private String marque;

    private String modele;

    private String numeroSerie;

    private Date dateAchat;

    private int garantieEnAnnee;

    private String statut;

    private int quantite;

    @JsonIgnore
    private Long departemnt_id;

    @ManyToOne
    @JoinColumn(name = "lab_id")
    private Laboratoire laboratoire;

}
