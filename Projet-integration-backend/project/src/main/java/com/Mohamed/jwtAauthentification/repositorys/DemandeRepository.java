package com.Mohamed.jwtAauthentification.repositorys;

import com.Mohamed.jwtAauthentification.modals.Demande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface DemandeRepository extends JpaRepository<Demande,Long> {

    List<Demande> findAllByDepartemnts_DepartmentId(Long departmentId);


}
