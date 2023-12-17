package com.Mohamed.jwtAauthentification.modals;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DemandeDeFournitures extends Demande{

    private String fournitures;

    private String type;

    private String marque;

    private String modele;
    private Integer quantite;
}
