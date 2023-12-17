package com.Mohamed.jwtAauthentification.modals;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Inheritance( strategy = InheritanceType.TABLE_PER_CLASS )
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Emplacement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String numero;

    @JsonIgnore
    private String type;

    private int capaciteEtudiant;

    private String typeTableau;

    @JsonIgnore
    private String etat;


    @ManyToOne
    @JoinColumn(name = "departemnt_id")
    private Departemnts departemnts;



}
