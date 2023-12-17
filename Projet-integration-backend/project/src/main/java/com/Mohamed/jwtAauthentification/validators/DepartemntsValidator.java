package com.Mohamed.jwtAauthentification.validators;

import com.Mohamed.jwtAauthentification.modals.Departemnts;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class DepartemntsValidator {

    public static List<String> validate(Departemnts departement) {
        List<String> errors = new ArrayList<>();

        if (departement == null) {
            errors.add("Veuillez renseigner le nom du département");
            errors.add("Veuillez renseigner le code du département");
            errors.add("Veuillez fournir le nombre de laboratoires.");
            errors.add("Veuillez fournir le nombre de salles de classe");
            errors.add("Veuillez renseigner une description pour le département");

            return errors;
        }
        if (!StringUtils.hasLength(departement.getNomDpartement())) {
            errors.add("Veuillez renseigner le nom du département");
        }
        if (!StringUtils.hasLength(departement.getCodeDpartement())) {
            errors.add("Veuillez renseigner le code du département");
        }
        if (!StringUtils.hasLength(departement.getDescriptionDepartement())) {
            errors.add("Veuillez renseigner une description pour le département");
        }

        if(departement.getNombreLaboratoiresMax() == -1){
            errors.add("Veuillez fournir le nombre de laboratoires.");
        }if (departement.getNombreSalleDeClasseMax() == -1){
            errors.add("Veuillez fournir le nombre de salles de classe");
        }

        return errors;
    }

}
