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
public class DemandeDassistanceTechnique extends Demande{

    private String probleme;

    private String descriptionProbleme;
}
