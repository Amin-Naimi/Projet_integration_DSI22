package com.Mohamed.jwtAauthentification.validators;

import com.Mohamed.jwtAauthentification.modals.Roles;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class RoleValidator {

    public static List<String> validate(Set<Roles> roles) {
        List<String> errors = new ArrayList<>();

        for(Roles role : roles) {
            if (role == null) {
                errors.add("Le champ de nom de rôle ne peut pas être vide.");
                errors.add("Le champ de description de rôle ne peut pas être vide.");
                return errors;
            }
            if (!StringUtils.hasLength(role.getRoleName())) {
                errors.add("Le champ de nom de rôle ne peut pas être vide.");
            }
            if (!StringUtils.hasLength(role.getRoleDescription())) {
                errors.add("Le champ de description de rôle ne peut pas être vide.");
            }
        }
        return errors;
    }
}
