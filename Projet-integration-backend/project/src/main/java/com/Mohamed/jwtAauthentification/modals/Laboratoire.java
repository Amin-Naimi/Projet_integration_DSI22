package com.Mohamed.jwtAauthentification.modals;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Laboratoire extends Emplacement{

    @JsonIgnore
    private String domaine;

    @JsonIgnore
    @OneToMany(mappedBy = "laboratoire")
    private List<Materiel> materielList ;

}
