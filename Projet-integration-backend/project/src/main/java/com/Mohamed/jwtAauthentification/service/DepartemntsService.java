package com.Mohamed.jwtAauthentification.service;

import com.Mohamed.jwtAauthentification.exception.EntityNotFoundException;
import com.Mohamed.jwtAauthentification.exception.ErrorCodes;
import com.Mohamed.jwtAauthentification.exception.InvalidEntityException;
import com.Mohamed.jwtAauthentification.exception.InvalidOperationException;
import com.Mohamed.jwtAauthentification.modals.Administration;
import com.Mohamed.jwtAauthentification.modals.Departemnts;
import com.Mohamed.jwtAauthentification.modals.Users;
import com.Mohamed.jwtAauthentification.repositorys.AdministrationRepository;
import com.Mohamed.jwtAauthentification.repositorys.DepartemntsRepository;
import com.Mohamed.jwtAauthentification.repositorys.UserRepository;
import com.Mohamed.jwtAauthentification.validators.DepartemntsValidator;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.*;

import static com.Mohamed.jwtAauthentification.exception.ErrorCodes.DEPARTMENT_NOT_FOUND;

@Service
@Slf4j
public class DepartemntsService {

    @Autowired
    private DepartemntsRepository departementRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AdministrationRepository administrationRepository;


    public Departemnts createDepartement(Departemnts departement) {
        List<String> errors = DepartemntsValidator.validate(departement);
        if (!errors.isEmpty()) {
            log.error("departement is not valid {}", departement);
            throw new InvalidEntityException("le departemnt n'est pas valide", ErrorCodes.DEPARTMENT_NOT_VALID, errors);
        }
        if (verifeNomDepartemnt(departement.getNomDpartement())) {
            throw new InvalidEntityException("Un autre Departemnt avec le meme nom existe deja", ErrorCodes.DEPARTMENT_ALREADY_EXISTS,
                    Collections.singletonList("Un autre Departemnt avec le meme nom existedeja dans la BDD"));

        }
        if (verifeCodeDepartemnt(departement.getCodeDpartement())) {
            throw new InvalidEntityException("Un autre Departemnt avec le meme code existe deja", ErrorCodes.DEPARTMENT_ALREADY_EXISTS,
                    Collections.singletonList("Un autre Departemnt avec le meme code existedeja dans la BDD"));

        }
        return departementRepository.save(departement);
    }

    public List<Departemnts> getAllDepartments() {
        return departementRepository.findAll();
    }

    public Departemnts updateDepartement(Long id, Departemnts departementDetails) {

        List<String> errors = DepartemntsValidator.validate(departementDetails);
        if (!errors.isEmpty()) {
            log.error("departement is not valid {}", departementDetails);
            throw new InvalidEntityException("le departemnt n'est pas valide", ErrorCodes.DEPARTMENT_NOT_VALID, errors);
        }

        if (id == null) {
            log.error("Departement ID is null");
        }

        Departemnts departement = departementRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Departement not found with id: " + id, DEPARTMENT_NOT_FOUND));

        departement.setNomDpartement(departementDetails.getNomDpartement());
        departement.setCodeDpartement(departementDetails.getCodeDpartement());
        departement.setDescriptionDepartement(departementDetails.getDescriptionDepartement());
        departement.setNombreLaboratoiresMax(departementDetails.getNombreLaboratoiresMax());
        departement.setNombreSalleDeClasseMax(departementDetails.getNombreSalleDeClasseMax());
        return departementRepository.save(departement);
    }

    public Departemnts getDepartementById(Long id) {
        if (id == null) {
            log.error("Departement ID is null");
        }
        return departementRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Departement not found with id: " + id, DEPARTMENT_NOT_FOUND));
    }


    public void deleteDepartement(Long id) {
        if (id == null) {
            log.error("Departement ID is null");
        }
        Departemnts departement = departementRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Departement not found with id: " + id, DEPARTMENT_NOT_FOUND));

        List<Users> usersList = findUsersByDepartmentId(id);
        if (!usersList.isEmpty()) {
            throw new InvalidOperationException("Impossible de supprimer ce departemnt qui est deja utilise",
                    ErrorCodes.DEPARTEMENT_ALREADY_IN_USE);
        }
        departementRepository.delete(departement);
    }

    public List<Users> getUsersByRoleAndDepartment(String roleName, Long departmentId) {
        List<Users> users = userRepository.findAllByRoleSet_RoleNameAndDepartemnts_DepartmentId(roleName, departmentId);
        return users;
    }

    public Map<String, BigInteger> countUsersByRoleAndDepartment(Long departmentId) {
        List<Object[]> results = userRepository.countUsersByRoleAndDepartment(departmentId);
        Map<String, BigInteger> countByRole = new HashMap<>();

        for (Object[] result : results) {
            String role = (String) result[0];
            BigInteger count = (BigInteger) result[1];
            countByRole.put(role, count);
        }
        return countByRole;
    }

    public long countDepartments() {
         long nbDeparetemnt = departementRepository.count();
        return nbDeparetemnt;
    }

    private boolean verifeNomDepartemnt(String nomdeparemnt) {
        Optional<Departemnts> departemnts = departementRepository.findByNomDpartement(nomdeparemnt);
        return departemnts.isPresent();
    }

    private boolean verifeCodeDepartemnt(String codeDepartemnt) {
        Optional<Departemnts> departemnts = departementRepository.findByCodeDpartement(codeDepartemnt);
        return departemnts.isPresent();
    }

    public void incrementNombreSalleDeClasse(Departemnts departemnts) {
        int nombreSalleDeClasseActuel = departemnts.getNombreSalleDeClasseActuel();
        int nombreSalleDeClasseIncrementer = nombreSalleDeClasseActuel + 1;
        departemnts.setNombreSalleDeClasseActuel(nombreSalleDeClasseIncrementer);
    }

    public void incrementNombreLaboratoire(Departemnts departemnts) {
        int nombreLaboratoiresActuel = departemnts.getNombreLaboratoiresActuel();
        int nombreLaboratoiresIncrementer = nombreLaboratoiresActuel + 1;
        departemnts.setNombreLaboratoiresActuel(nombreLaboratoiresIncrementer);
    }

    public void desincrementNombreSalleDeClasse(Departemnts departemnts) {
        int nombreSalleDeClasseActuel = departemnts.getNombreSalleDeClasseActuel();
        int nombreSalleDeClasseDesIncrementer = nombreSalleDeClasseActuel - 1;
        departemnts.setNombreSalleDeClasseActuel(nombreSalleDeClasseDesIncrementer);
    }

    public void desIncrementNombreLaboratoire(Departemnts departemnts) {
        int nombreLaboratoiresActuel = departemnts.getNombreLaboratoiresActuel();
        int nombreLaboratoiresdecrmenter = nombreLaboratoiresActuel - 1;
        departemnts.setNombreLaboratoiresActuel(nombreLaboratoiresdecrmenter);
    }

    public List<Users> findUsersByDepartmentId(Long departemntId){
        if (departemntId == null) {
            log.error("Departement ID is null");
        }
        List<Users> usersList = userRepository.findByDepartemnts_DepartmentId(departemntId);
        return usersList;
    }



}
