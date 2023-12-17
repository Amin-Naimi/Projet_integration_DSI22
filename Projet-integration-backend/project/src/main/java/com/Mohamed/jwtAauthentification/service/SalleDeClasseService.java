package com.Mohamed.jwtAauthentification.service;

import com.Mohamed.jwtAauthentification.exception.EntityNotFoundException;
import com.Mohamed.jwtAauthentification.exception.ErrorCodes;
import com.Mohamed.jwtAauthentification.exception.InvalidEntityException;
import com.Mohamed.jwtAauthentification.modals.Departemnts;
import com.Mohamed.jwtAauthentification.modals.SalleDeClasse;
import com.Mohamed.jwtAauthentification.repositorys.DepartemntsRepository;
import com.Mohamed.jwtAauthentification.repositorys.SalleDeClasseRepository;
import com.Mohamed.jwtAauthentification.validators.EmplacementValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static com.Mohamed.jwtAauthentification.enumrations.EtatEmplacement.DISPONIBLE;
import static com.Mohamed.jwtAauthentification.exception.ErrorCodes.EMPLACEMENT_NOT_FOUND;

@Service
@Slf4j
public class SalleDeClasseService {


    @Autowired
    private SalleDeClasseRepository salleDeClasseRepository;

    @Autowired
    private DepartemntsService departemntsService;

    @Autowired
    DepartemntsRepository departemntsRepository;

    public SalleDeClasse create(SalleDeClasse salleDeClasse) {
        List<String> errors = EmplacementValidator.validate(salleDeClasse);
        if (!errors.isEmpty() ) {
            log.error("salleDeClasse is not valid {}", salleDeClasse);
            throw new InvalidEntityException("le salleDeClasse n'est pas valide", ErrorCodes.EMPLACEMENT_NOT_VALID, errors);
        }

        if (verifeNum(salleDeClasse.getNumero())) {
            throw new InvalidEntityException("Un autre salleDeClasse avec le meme numero existe deja", ErrorCodes.EMPLACEMENT_ALREADY_EXISTS,
                    Collections.singletonList("Un autre Laboratoire avec le meme numero existedeja dans la BDD"));
        }

        Departemnts departemnt = departemntsService.getDepartementById(salleDeClasse.getDepartemnts().getDepartmentId());
        int nombreSalleDeClasseMax = departemnt.getNombreSalleDeClasseMax();
        int nombreSalleDeClasseActuel = departemnt.getNombreSalleDeClasseActuel();

        if (nombreSalleDeClasseActuel >= nombreSalleDeClasseMax) {
            throw new InvalidEntityException("Il n'y a pas d'espace libre pour ajouter une nouvelle salle de classe dans ce département", ErrorCodes.DEPARTEMENT_FULL,
                    Collections.singletonList("Le nombre maximum de salles de classe autorisé dans ce département a été atteint"));
        }

        departemntsService.incrementNombreSalleDeClasse(departemnt);
        departemntsRepository.save(departemnt);

        salleDeClasse.setType("Salle De Classe");
        salleDeClasse.setEtat(DISPONIBLE.name());

        return salleDeClasseRepository.save(salleDeClasse);

    }

    public SalleDeClasse update(Long salleDeclasseId, SalleDeClasse SalleDeClasseDetails) {

        if (salleDeclasseId == null) {
            log.error("salleDeclasse ID is null");
        }

        List<String> errors = EmplacementValidator.validate(SalleDeClasseDetails);
        if (!errors.isEmpty()) {
            log.error("Salle De Classe is not valid {}", SalleDeClasseDetails);
            throw new InvalidEntityException("le Salle De Classe n'est pas valide", ErrorCodes.EMPLACEMENT_NOT_VALID, errors);
        }

        Optional<SalleDeClasse> optionalSalleDeClasse = salleDeClasseRepository.findById(salleDeclasseId);

        if (optionalSalleDeClasse.isEmpty()) {
            throw new EntityNotFoundException("le Salle De Classe not found with id: " + salleDeclasseId, EMPLACEMENT_NOT_FOUND);
        }

        SalleDeClasse salleDeClasse = optionalSalleDeClasse.get();

        salleDeClasse.setNumero(SalleDeClasseDetails.getNumero());
        salleDeClasse.setCapaciteEtudiant(SalleDeClasseDetails.getCapaciteEtudiant());
        salleDeClasse.setTypeTableau(SalleDeClasseDetails.getTypeTableau());
        salleDeClasse.setEtat(SalleDeClasseDetails.getEtat());
        salleDeClasse.setType("Salle De Classe");

        return salleDeClasseRepository.save(salleDeClasse);
    }

    public void delete(Long id) {
        if (id == null) {
            log.error("le Salle De Classe ID is null");
        }
        SalleDeClasse salleDeClasse = salleDeClasseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("salle De classeId not found with id: " + id, EMPLACEMENT_NOT_FOUND));

        Departemnts departemnt = departemntsService.getDepartementById(salleDeClasse.getDepartemnts().getDepartmentId());
        departemntsService.desincrementNombreSalleDeClasse(departemnt);
        departemntsRepository.save(departemnt);
        salleDeClasseRepository.delete(salleDeClasse);
    }

    public List<SalleDeClasse> getAllSalleDeClasse() {
        return salleDeClasseRepository.findAll();
    }

    public SalleDeClasse getSalleDClasseById(Long id) {
        if (id == null) {
            log.error("salleDeClasse ID is null");
        }
        return salleDeClasseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(" not found with id: " + id, EMPLACEMENT_NOT_FOUND));
    }

    private boolean verifeNum(String num) {
        Optional<SalleDeClasse> SalleDeClasse = salleDeClasseRepository.findByNumero(num);
        return SalleDeClasse.isPresent();
    }

    public List<SalleDeClasse> findAllSalleDClasseByDepId(Long departmentId) {
        return salleDeClasseRepository.findAllByDepartemnts_DepartmentId(departmentId);
    }

    public int countByDepartmentId(Long departmentId) {
        return salleDeClasseRepository.countByDepartmentId(departmentId);
    }


}
