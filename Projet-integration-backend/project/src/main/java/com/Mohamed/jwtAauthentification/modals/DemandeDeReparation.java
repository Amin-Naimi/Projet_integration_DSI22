package com.Mohamed.jwtAauthentification.modals;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DemandeDeReparation extends Demande{

    private String nomEquipement;

    private String numeroSerie;

    private String descriptionPanne;
}
