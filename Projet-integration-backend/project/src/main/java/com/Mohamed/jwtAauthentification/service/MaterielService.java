package com.Mohamed.jwtAauthentification.service;

import com.Mohamed.jwtAauthentification.exception.EntityNotFoundException;
import com.Mohamed.jwtAauthentification.exception.ErrorCodes;
import com.Mohamed.jwtAauthentification.exception.InvalidEntityException;
import com.Mohamed.jwtAauthentification.modals.Laboratoire;
import com.Mohamed.jwtAauthentification.modals.Materiel;
import com.Mohamed.jwtAauthentification.repositorys.LaboratoireRepository;
import com.Mohamed.jwtAauthentification.repositorys.MaterielRepository;
import com.Mohamed.jwtAauthentification.validators.MaterielValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static com.Mohamed.jwtAauthentification.enumrations.MaterielEnum.*;

@Service
@Slf4j
public class MaterielService {

    @Autowired
    private MaterielRepository materielRepository;

    @Autowired
    private LaboratoireRepository laboratoireRepository;

    public Materiel saveMateriel(Materiel materiel){
        List<String> errors = MaterielValidator.validate(materiel);
        if (!errors.isEmpty()) {
            log.error("Materiel is not valid {}", materiel);
            throw new InvalidEntityException("le Materiel n'est pas valide", ErrorCodes.MATERIEL_NOT_VALID, errors);
        }
        if (verifeNumeroSerie(materiel.getNumeroSerie())) {
            throw new InvalidEntityException("Un autre materiel avec le meme numero de series existe deja", ErrorCodes.MATERIEL_SERIES_ALREADY_EXISTS,
                    Collections.singletonList("Changer le nuemro de series svp"));
        }

        Long idlaboratoire = materiel.getLaboratoire().getId();
        Laboratoire laboratoire = laboratoireRepository.findById(idlaboratoire).get();
        Long departemntId = laboratoire.getDepartemnts().getDepartmentId();
        log.info("labo departemnt id {}",laboratoire.getDepartemnts().getDepartmentId());

        materiel.setDepartemnt_id(departemntId);
        materiel.setStatut(EN_STOCK.name());
        return materielRepository.save(materiel);
    }

    public Materiel update(Long idMateriel, Materiel materielDetails) {

        if (idMateriel == null) {
            log.error("Materiel ID is null");
        }

        List<String> errors = MaterielValidator.validate(materielDetails);
        if (!errors.isEmpty()) {
            log.error("Materiel is not valid {}", materielDetails);
            throw new InvalidEntityException("le Materiel n'est pas valide", ErrorCodes.MATERIEL_NOT_VALID, errors);
        }

        Optional<Materiel> optionalMateriel = materielRepository.findById(idMateriel);

        if (optionalMateriel.isEmpty()) {
            throw new EntityNotFoundException("Materiel not found with id: " + idMateriel, ErrorCodes.MATERIEL_NOT_FOUND);
        }

        Materiel materiel = optionalMateriel.get();

        materiel.setNom(materielDetails.getNom());
        materiel.setType(materielDetails.getType());
        materiel.setMarque(materielDetails.getMarque());
        materiel.setModele(materielDetails.getModele());
        materiel.setNumeroSerie(materielDetails.getNumeroSerie());
        materiel.setDateAchat(materielDetails.getDateAchat());
        materiel.setGarantieEnAnnee(materielDetails.getGarantieEnAnnee());
        materiel.setQuantite(materielDetails.getQuantite());
        materiel.setStatut(EN_STOCK.name());


        return materielRepository.save(materiel);
    }

    public void delete(Long idMateriel) {
        if(idMateriel == null){
            log.error("Materiel Id is null");
        }
        Materiel materiel = materielRepository.findById(idMateriel)
                .orElseThrow(() -> new EntityNotFoundException("Materiel not found with id: " + idMateriel, ErrorCodes.MATERIEL_NOT_FOUND));

        materielRepository.deleteById(idMateriel);
    }

    public List<Materiel> getAllMateriel(){
        return materielRepository.findAll();

    }

    public Materiel getMaterielById(Long id) {
        if (id == null) {
            log.error("Materiel ID is null");
        }
        return materielRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Materiel not found with id: " + id, ErrorCodes.MATERIEL_NOT_FOUND));
    }

    public List<Materiel> findAllMatByLaboId(Long laboId){
        return materielRepository.findAllByLaboratoire_Id(laboId);
    }


    private boolean verifeNumeroSerie(String numeroSerie) {
        Optional<Materiel> materiel = materielRepository.findByNumeroSerie(numeroSerie);
        return materiel.isPresent();
    }

    public Materiel findMaterielByNumeroSerie(String numeroSerie){
        if(numeroSerie == null){
            log.error(" Numero Serie Id is null");
        }
        Materiel materiel = materielRepository.findByNumeroSerie(numeroSerie)
                .orElseThrow(() -> new EntityNotFoundException("Materiel not found with Numero Serie: " + numeroSerie, ErrorCodes.MATERIEL_NOT_FOUND));

        return materiel;
    }

    public Materiel setEtatEnService(Long id) {
        Materiel materiel = materielRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Matériel non trouvé"));
        materiel.setStatut(EN_SERVICE.name());
        return materielRepository.save(materiel);
    }

    public Materiel setEtatEnReparation(Long id) {
        Materiel materiel = materielRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Matériel non trouvé"));
        materiel.setStatut(EN_REPARATION.name());
        return materielRepository.save(materiel);
    }

    public Materiel setEtatEnRuptureStock(Long id) {
        Materiel materiel = materielRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Matériel non trouvé"));
        materiel.setStatut(EN_REPTURE_STOCK.name());
        return materielRepository.save(materiel);
    }


}
