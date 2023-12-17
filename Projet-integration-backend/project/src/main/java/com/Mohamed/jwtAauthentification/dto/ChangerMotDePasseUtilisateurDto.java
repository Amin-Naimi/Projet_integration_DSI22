package com.Mohamed.jwtAauthentification.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ChangerMotDePasseUtilisateurDto {

    private Long id;

    private String motDePasse;

    private String confirmMotDePasse;
}
