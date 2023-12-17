package com.Mohamed.jwtAauthentification.service;

import com.Mohamed.jwtAauthentification.exception.EntityNotFoundException;
import com.Mohamed.jwtAauthentification.exception.ErrorCodes;
import com.Mohamed.jwtAauthentification.exception.InvalidEntityException;
import com.Mohamed.jwtAauthentification.modals.Departemnts;
import com.Mohamed.jwtAauthentification.modals.Laboratoire;
import com.Mohamed.jwtAauthentification.repositorys.DepartemntsRepository;
import com.Mohamed.jwtAauthentification.repositorys.LaboratoireRepository;
import com.Mohamed.jwtAauthentification.validators.EmplacementValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static com.Mohamed.jwtAauthentification.enumrations.EtatEmplacement.DISPONIBLE;


@Service
@Slf4j
public class LaboratoireService {

    @Autowired
    private LaboratoireRepository laboratoireRepository;

    @Autowired
    private DepartemntsService departemntsService;

    @Autowired
    private DepartemntsRepository departementRepository;


    public Laboratoire create(Laboratoire laboratoire) {
        List<String> errors = EmplacementValidator.validate(laboratoire);
        if (!errors.isEmpty()) {
            log.error("Laboratoire is not valid {}", laboratoire);
            throw new InvalidEntityException("le Laboratoire n'est pas valide", ErrorCodes.EMPLACEMENT_NOT_VALID, errors);
        }

        if (verifeNum(laboratoire.getNumero())) {
            throw new InvalidEntityException("Un autre Laboratoire avec le meme numero existe deja", ErrorCodes.EMPLACEMENT_ALREADY_EXISTS,
                    Collections.singletonList("Un autre Laboratoire avec le meme numero existedeja dans la BDD"));
        }
        Departemnts departemnt = departemntsService.getDepartementById(laboratoire.getDepartemnts().getDepartmentId());
        int nombreLaboratoireMax = departemnt.getNombreLaboratoiresMax();
        int nombreLaboratoiresActuel = departemnt.getNombreLaboratoiresActuel();
        String departemntNom = departemnt.getNomDpartement();

        if (nombreLaboratoiresActuel >= nombreLaboratoireMax) {
            throw new InvalidEntityException("Il n'y a pas d'espace libre pour ajouter un nouveau labo dans ce département", ErrorCodes.DEPARTEMENT_FULL,
                    Collections.singletonList("Le nombre maximum des laboratoire autorisé dans ce département a été atteint"));
        }


        laboratoire.setType("Laboratoire");
        laboratoire.setEtat(DISPONIBLE.name());
        laboratoire.setDomaine(departemntNom);

        departemntsService.incrementNombreLaboratoire(departemnt);
        departementRepository.save(departemnt);
        return laboratoireRepository.save(laboratoire);

    }

    public Laboratoire update(Long idLabo, Laboratoire laboratoireDetails) {

        if (idLabo == null) {
            log.error("Laboratoire ID is null");
        }

        List<String> errors = EmplacementValidator.validate(laboratoireDetails);
        if (!errors.isEmpty()) {
            log.error("Laboratoire is not valid {}", laboratoireDetails);
            throw new InvalidEntityException("le Laboratoire n'est pas valide", ErrorCodes.EMPLACEMENT_NOT_VALID, errors);
        }

        Optional<Laboratoire> optionalLaboratoire = laboratoireRepository.findById(idLabo);

        if (optionalLaboratoire.isEmpty()) {
            throw new EntityNotFoundException("Departement not found with id: " + idLabo, ErrorCodes.EMPLACEMENT_NOT_FOUND);
        }

        Laboratoire laboratoire = optionalLaboratoire.get();

        laboratoire.setNumero(laboratoireDetails.getNumero());
        laboratoire.setType(laboratoireDetails.getType());
        laboratoire.setCapaciteEtudiant(laboratoireDetails.getCapaciteEtudiant());
        laboratoire.setTypeTableau(laboratoireDetails.getTypeTableau());
        laboratoire.setEtat(laboratoireDetails.getEtat());
        laboratoire.setDomaine(laboratoireDetails.getDomaine());

        return laboratoireRepository.save(laboratoire);
    }

    public void delete(Long id) {
        if (id == null) {
            log.error("Laboratoire ID is null");
        }
        Laboratoire laboratoire = laboratoireRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Laboratoire not found with id: " + id, ErrorCodes.EMPLACEMENT_NOT_FOUND));

        Departemnts departemnt = departemntsService.getDepartementById(laboratoire.getDepartemnts().getDepartmentId());
        departemntsService.desIncrementNombreLaboratoire(departemnt);
        departementRepository.save(departemnt);

        laboratoireRepository.delete(laboratoire);

    }

    public List<Laboratoire> getAllLaboratoires() {
        return laboratoireRepository.findAll();
    }

    public Laboratoire getLaboratoireById(Long id) {
        if (id == null) {
            log.error("Laboratoire ID is null");
        }
        return laboratoireRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Departement not found with id: " + id, ErrorCodes.DEPARTMENT_NOT_FOUND));
    }

    private boolean verifeNum(String num) {
        Optional<Laboratoire> laboratoire = laboratoireRepository.findByNumero(num);
        return laboratoire.isPresent();
    }

    public List<Laboratoire> findAllLaboByDepId(Long departmentId) {
        return laboratoireRepository.findAllByDepartemnts_DepartmentId(departmentId);
    }

    public int countByDepartmentId(Long departmentId) {
        return laboratoireRepository.countByDepartmentId(departmentId);
    }

}


