package com.Mohamed.jwtAauthentification.repositorys;

import com.Mohamed.jwtAauthentification.modals.Materiel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MaterielRepository extends JpaRepository<Materiel,Long> {

    List<Materiel> findAllByLaboratoire_Id(Long laboratoireId);
    Optional<Materiel> findByNumeroSerie(String numeroSerie);


}
