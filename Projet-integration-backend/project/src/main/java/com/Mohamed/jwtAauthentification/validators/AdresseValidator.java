package com.Mohamed.jwtAauthentification.validators;

import com.Mohamed.jwtAauthentification.modals.Adresse;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class AdresseValidator {

    public static List<String> validate(Adresse adresse) {
        List<String> errors = new ArrayList<>();

        if (adresse == null) {
            errors.add("Veuillez renseigner votre région");
            errors.add("Veuillez renseigner la ville'");
            errors.add("Veuillez renseigner le code postal'");
            return errors;
        }
        if (!StringUtils.hasLength(adresse.getRegion())) {
            errors.add("Veuillez renseigner votre région");
        }
        if (!StringUtils.hasLength(adresse.getVille())) {
            errors.add("Veuillez renseigner la ville'");
        }
        if (!StringUtils.hasLength(adresse.getCodePostale())) {
            errors.add("Veuillez renseigner le code postal'");
        }
        return errors;
    }
}
