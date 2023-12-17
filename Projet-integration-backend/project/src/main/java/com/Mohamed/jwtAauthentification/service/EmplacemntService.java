package com.Mohamed.jwtAauthentification.service;

import com.Mohamed.jwtAauthentification.exception.EntityNotFoundException;
import com.Mohamed.jwtAauthentification.modals.Emplacement;
import com.Mohamed.jwtAauthentification.repositorys.EmplacemntRepositorys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.Mohamed.jwtAauthentification.enumrations.EtatEmplacement.*;

@Service
@Slf4j
public class EmplacemntService {

    @Autowired
    private EmplacemntRepositorys emplacemntRepositorys;

    public Emplacement setEtatOccupe(Long id) {
        Emplacement emplacement = emplacemntRepositorys.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Emplacement non trouvé"));
        emplacement.setEtat(OCCUPE.name());
        return emplacemntRepositorys.save(emplacement);
    }

    public Emplacement setEtatEnMaintenance(Long id) {
        Emplacement emplacement = emplacemntRepositorys.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Emplacement non trouvé"));
        emplacement.setEtat(EN_MAINTENANCE.name());
        return emplacemntRepositorys.save(emplacement);
    }

    public Emplacement setEtatFerme(Long id) {
        Emplacement emplacement = emplacemntRepositorys.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Emplacement non trouvé"));
        emplacement.setEtat(FERME.name());
        return emplacemntRepositorys.save(emplacement);
    }
}