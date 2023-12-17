package com.Mohamed.jwtAauthentification.service;

import com.Mohamed.jwtAauthentification.exception.EntityNotFoundException;
import com.Mohamed.jwtAauthentification.exception.ErrorCodes;
import com.Mohamed.jwtAauthentification.exception.InvalidEntityException;
import com.Mohamed.jwtAauthentification.exception.InvalidOperationException;
import com.Mohamed.jwtAauthentification.modals.*;
import com.Mohamed.jwtAauthentification.repositorys.DemandeRepository;
import com.Mohamed.jwtAauthentification.validators.DemandeValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.Mohamed.jwtAauthentification.enumrations.EtatDemande.*;

@Service
@Slf4j
public class DemandeService {

    @Autowired
    private DemandeRepository demandeRepository;

    public DemandeDeReparation creerDemandeDeReparation(DemandeDeReparation demande) {
        List<String> errors = DemandeValidator.validate(demande);
        if (!errors.isEmpty()) {
            log.error("demande is not valid {}", demande);
            throw new InvalidEntityException("la demande n'est pas valide", ErrorCodes.DEMANDE_NOT_VALID, errors);
        }
        demande.setEtat(EN_ATTENTE.name());
        return demandeRepository.save(demande);
    }

    public DemandeDentretien creerDemandeDentretien(DemandeDentretien demande) {
        List<String> errors = DemandeValidator.validate(demande);
        if (!errors.isEmpty()) {
            log.error("demande is not valid {}", demande);
            throw new InvalidEntityException("la demande n'est pas valide", ErrorCodes.DEMANDE_NOT_VALID, errors);
        }
        demande.setEtat(EN_ATTENTE.name());
        return demandeRepository.save(demande);
    }

    public DemandeDeFournitures creerDemandeDeFournitures(DemandeDeFournitures demande) {
        List<String> errors = DemandeValidator.validate(demande);
        if (!errors.isEmpty()) {
            log.error("demande is not valid {}", demande);
            throw new InvalidEntityException("la demande n'est pas valide", ErrorCodes.DEMANDE_NOT_VALID, errors);
        }
        demande.setEtat(EN_ATTENTE.name());
        return demandeRepository.save(demande);
    }

    public DemandeDassistanceTechnique creerDemandeDassistanceTechnique(DemandeDassistanceTechnique demande) {
        List<String> errors = DemandeValidator.validate(demande);
        if (!errors.isEmpty()) {
            log.error("demande is not valid {}", demande);
            throw new InvalidEntityException("la demande n'est pas valide", ErrorCodes.DEMANDE_NOT_VALID, errors);
        }
        demande.setEtat(EN_ATTENTE.name());
        return demandeRepository.save(demande);
    }

    public Demande approuver(Long id) {
        Demande demande = demandeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Demande non trouvée", ErrorCodes.DEMANDE_NOT_FOUND));
        demande.setEtat(APPROUVEE.name());
        return demandeRepository.save(demande);
    }

    public Demande rejeter(Long id) {
        Demande demande = demandeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Demande non trouvée", ErrorCodes.DEMANDE_NOT_FOUND));
        demande.setEtat(REJETEE.name());
        return demandeRepository.save(demande);
    }

    public Demande commencerTraitement(Long id) {
        Demande demande = demandeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Demande non trouvée", ErrorCodes.DEMANDE_NOT_FOUND));
        demande.setEtat(EN_COURS_DU_TRAITEMENT.name());
        return demandeRepository.save(demande);
    }

    public Demande terminer(Long id) {
        Demande demande = demandeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Demande non trouvée", ErrorCodes.DEMANDE_NOT_FOUND));
        demande.setEtat(TERMINEE.name());
        return demandeRepository.save(demande);
    }

    public List<Demande> findAllByDepartments_DepartmentId(Long departmentId) {
        return demandeRepository.findAllByDepartemnts_DepartmentId(departmentId);
    }

    public void delete(Long id) {

        demandeRepository.deleteById(id);
    }

}
