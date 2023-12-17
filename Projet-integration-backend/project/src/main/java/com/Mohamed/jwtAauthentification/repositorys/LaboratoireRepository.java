package com.Mohamed.jwtAauthentification.repositorys;

import com.Mohamed.jwtAauthentification.modals.Laboratoire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LaboratoireRepository extends JpaRepository<Laboratoire, Long> {

    Optional<Laboratoire> findByNumero(String numero);

    List<Laboratoire> findAllByDepartemnts_DepartmentId(Long departmentId);

    @Query(value = "SELECT COUNT(*) FROM laboratoire l WHERE l.departemnt_id = :departmentId", nativeQuery = true)
    int countByDepartmentId(Long departmentId);


}
