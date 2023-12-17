package com.Mohamed.jwtAauthentification.modals;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nom;

    private String prenom;

    private int numCin;

    private String dateNaissance;

    private String email;

    private String password;

    private String numTel;

    private String nomDepartement;


    @Embedded
    private Adresse adresse;

    //@ManyToMany(cascade = CascadeType.DETACH,fetch = FetchType.EAGER)
    //@ManyToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "USERS_ROLES",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
    private Set<Roles> roleSet;

    @ManyToOne
    @JoinColumn(name = "departemnt_id")
    private Departemnts departemnts;
}
