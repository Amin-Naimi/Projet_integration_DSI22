package com.Mohamed.jwtAauthentification.repositorys;

import com.Mohamed.jwtAauthentification.modals.Users;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {

    Optional<Users> findByNumCin (int numCin);
    Optional<Users> findByEmail(String email);

    Optional<Users> findByNumTel(String num);

    @Query(value = "SELECT r.role_name, COUNT(u.id) FROM users_roles ur JOIN users u ON ur.user_id = u.id JOIN roles r ON ur.role_id = r.role_id GROUP BY r.role_name",nativeQuery = true)
    List<Object[]> countUsersByRole();

    List<Users> findAllByRoleSet_RoleName(String roleName);

    List<Users> findAllByRoleSet_RoleNameAndDepartemnts_DepartmentId(String roleName, Long departmentId);
    Optional<Users> findByRoleSet_RoleNameAndDepartemnts_DepartmentId(String roleName, Long departmentId);


    @Query(value = "SELECT r.role_name, COUNT(u.id) FROM users u JOIN users_roles ur ON u.id = ur.user_id JOIN roles r ON ur.role_id = r.role_id JOIN departemnts d ON u.departemnt_id = d.department_id WHERE d.department_id = :departmentId GROUP BY r.role_name", nativeQuery = true)
    List<Object[]> countUsersByRoleAndDepartment(Long departmentId);

    List<Users> findByDepartemnts_DepartmentId(Long departemntId);


}
