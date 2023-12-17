package com.Mohamed.jwtAauthentification.modals;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Departemnts {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;

    private String nomDpartement;

    private String codeDpartement;

    private String descriptionDepartement;

    @JsonIgnore
    private int nombreSalleDeClasseActuel = 0;

    @JsonIgnore
    private int nombreLaboratoiresActuel = 0;

    private int nombreSalleDeClasseMax;

    private int nombreLaboratoiresMax;

    @JsonIgnore
    @OneToMany(mappedBy = "departemnts")
    private List<Users> users;

    @JsonIgnore
    @OneToMany(mappedBy = "departemnts")
    private List<Emplacement> emplacementList ;

    @JsonIgnore
    @OneToMany(mappedBy = "departemnts")
    private List<Demande> demandeList  ;

}
