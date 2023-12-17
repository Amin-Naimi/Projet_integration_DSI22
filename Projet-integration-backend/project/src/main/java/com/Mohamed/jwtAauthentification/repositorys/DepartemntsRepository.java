package com.Mohamed.jwtAauthentification.repositorys;

import com.Mohamed.jwtAauthentification.modals.Departemnts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartemntsRepository extends JpaRepository<Departemnts, Long> {

    Optional<Departemnts> findByNomDpartement(String nomDpartement);
    Optional<Departemnts> findByCodeDpartement(String codeDpartement);


    long count();


}
