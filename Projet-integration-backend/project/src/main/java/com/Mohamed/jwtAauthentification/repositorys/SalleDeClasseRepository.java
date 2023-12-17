package com.Mohamed.jwtAauthentification.repositorys;

import com.Mohamed.jwtAauthentification.modals.Laboratoire;
import com.Mohamed.jwtAauthentification.modals.SalleDeClasse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SalleDeClasseRepository extends JpaRepository<SalleDeClasse, Long> {

    Optional<SalleDeClasse> findByNumero(String numero);

    List<SalleDeClasse> findAllByDepartemnts_DepartmentId(Long departmentId);

    @Query(value = "SELECT COUNT(*) FROM salle_de_classe salle WHERE salle.departemnt_id = :departmentId", nativeQuery = true)
    int countByDepartmentId(Long departmentId);

}
