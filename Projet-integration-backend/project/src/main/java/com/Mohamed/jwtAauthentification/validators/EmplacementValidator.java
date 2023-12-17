package com.Mohamed.jwtAauthentification.validators;

import com.Mohamed.jwtAauthentification.modals.Emplacement;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class EmplacementValidator {

    public static List<String> validate(Emplacement emplacement) {
        List<String> errors = new ArrayList<>();

        if (emplacement == null) {
            errors.add("Veuillez renseigner le numéro de l'emplacement");
            errors.add("Veuillez renseigner la capacité étudiante de l'emplacement");
            errors.add("Veuillez renseigner le type de tableau de l'emplacement");
            return errors;
        }
        if (!StringUtils.hasLength(emplacement.getNumero())) {
            errors.add("Veuillez renseigner le numéro de l'emplacement");
        }
        if (emplacement.getCapaciteEtudiant() <= 0) {
            errors.add("Veuillez renseigner une capacité étudiante positive pour l'emplacement");
        }
        if (!StringUtils.hasLength(emplacement.getTypeTableau())) {
            errors.add("Veuillez renseigner le type de tableau de l'emplacement");
        }

        return errors;
    }

}
