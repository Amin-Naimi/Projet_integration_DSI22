package com.Mohamed.jwtAauthentification.validators;

import com.Mohamed.jwtAauthentification.modals.Demande;

import java.util.ArrayList;
import java.util.List;

public class DemandeValidator {

    public static List<String> validate(Demande demande) {
        List<String> errors = new ArrayList<>();
        if(demande == null){
            errors.add("La date de création ne peut pas être vide.");
            errors.add("L'ID du professeur ne peut pas être vide.");

            return errors;
        }

        if (demande.getDateCreation() == null) {
            errors.add("La date de création ne peut pas être vide.");
        }
        if (demande.getProfesseurCin() == null) {
            errors.add("L'ID du professeur ne peut pas être vide.");
        }

        return errors;
    }

}
