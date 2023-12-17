package com.Mohamed.jwtAauthentification.validators;

import com.Mohamed.jwtAauthentification.modals.Users;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UserValidator {

    public static List<String> validate(Users utilisateur) {
        List<String> errors = new ArrayList<>();
        if (utilisateur == null) {
            errors.add("Veuillez renseigner le nom d'utilisateur");
            errors.add("Veuillez renseigner le prenom d'utilisateur");
            errors.add("Veuillez renseigner le CIN d'utilisateur");
            errors.add("Veuillez renseigner l'email d'utilisateur");
            errors.add("Veuillez renseigner le mot de passe d'utilisateur");
            errors.add("Veuillez renseigner le role de l' utilisateur");
            errors.add("Veuillez renseigner l'adresse d'utilisateur");
            errors.add("Veuillez renseigner le departemnt d'utilisateur");
            errors.addAll(AdresseValidator.validate(null));
            errors.addAll(RoleValidator.validate(null));
            return errors;
        }

        if (!StringUtils.hasLength(utilisateur.getNom())) {
            errors.add("Veuillez renseigner le nom d'utilisateur");
        }
        if (!StringUtils.hasLength(utilisateur.getPrenom())) {
            errors.add("Veuillez renseigner le prenom d'utilisateur");
        }
        if (!StringUtils.hasLength(Integer.toString(utilisateur.getNumCin()))) {
            errors.add("Veuillez renseigner le CIN d'utilisateur");
        }
        if (!StringUtils.hasLength(utilisateur.getEmail())) {
            errors.add("Veuillez renseigner l'email d'utilisateur");
        }
        if (!StringUtils.hasLength(utilisateur.getPassword())) {
            errors.add("Veuillez renseigner le mot de passe d'utilisateur");
        }
        if (utilisateur.getDateNaissance() == null) {
            errors.add("Veuillez renseigner la date de naissance d'utilisateur");
        }
        if (utilisateur.getNumTel() == null) {
            errors.add("Veuillez renseigner la date de naissance d'utilisateur");
        }
        if(utilisateur.getDepartemnts().getDepartmentId() ==null){
            errors.add("Veuillez renseigner le departemnt d'utilisateur");

        }
        errors.addAll(AdresseValidator.validate(utilisateur.getAdresse()));
        errors.addAll(RoleValidator.validate(utilisateur.getRoleSet()));

        return errors;
    }
}
