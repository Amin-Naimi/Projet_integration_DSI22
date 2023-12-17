package com.Mohamed.jwtAauthentification.modals;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Demande {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date dateCreation;

    private String etat;

    private Long professeurCin;

    @ManyToOne
    @JoinColumn(name = "departemnt_id")
    private Departemnts departemnts;

}
