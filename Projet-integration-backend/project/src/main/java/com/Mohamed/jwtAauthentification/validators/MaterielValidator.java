package com.Mohamed.jwtAauthentification.validators;

import com.Mohamed.jwtAauthentification.modals.Materiel;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class MaterielValidator {

    public static List<String> validate(Materiel materiel) {
        List<String> errors = new ArrayList<>();

        if (materiel == null) {
            errors.add("Veuillez renseigner le nom du matériel");
            errors.add("Veuillez renseigner le type du matériel");
            errors.add("Veuillez renseigner la marque du matériel");
            errors.add("Veuillez renseigner le modèle du matériel");
            errors.add("Veuillez renseigner le numéro de série du matériel");
            errors.add("Veuillez renseigner la date d'achat du matériel");
            errors.add("Veuillez renseigner la garantie en année du matériel");
            return errors;
        }
        if (!StringUtils.hasLength(materiel.getNom())) {
            errors.add("Veuillez renseigner le nom du matériel");
        }
        if (!StringUtils.hasLength(materiel.getType())) {
            errors.add("Veuillez renseigner le type du matériel");
        }
        if (!StringUtils.hasLength(materiel.getMarque())) {
            errors.add("Veuillez renseigner la marque du matériel");
        }
        if (!StringUtils.hasLength(materiel.getModele())) {
            errors.add("Veuillez renseigner le modèle du matériel");
        }
        if (!StringUtils.hasLength(materiel.getNumeroSerie())) {
            errors.add("Veuillez renseigner le numéro de série du matériel");
        }
        if (materiel.getDateAchat() == null) {
            errors.add("Veuillez renseigner la date d'achat du matériel");
        }
        if (materiel.getGarantieEnAnnee() <= 0) {
            errors.add("Veuillez renseigner la garantie en année du matériel");
        }
        return errors;
    }

}
