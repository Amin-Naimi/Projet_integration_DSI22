package com.Mohamed.jwtAauthentification.service;

import com.Mohamed.jwtAauthentification.dto.ChangerMotDePasseUtilisateurDto;
import com.Mohamed.jwtAauthentification.exception.EntityNotFoundException;
import com.Mohamed.jwtAauthentification.exception.ErrorCodes;
import com.Mohamed.jwtAauthentification.exception.InvalidEntityException;
import com.Mohamed.jwtAauthentification.exception.InvalidOperationException;
import com.Mohamed.jwtAauthentification.modals.Departemnts;
import com.Mohamed.jwtAauthentification.modals.Roles;
import com.Mohamed.jwtAauthentification.modals.Users;
import com.Mohamed.jwtAauthentification.repositorys.DepartemntsRepository;
import com.Mohamed.jwtAauthentification.repositorys.RolesRepository;
import com.Mohamed.jwtAauthentification.repositorys.UserRepository;
import com.Mohamed.jwtAauthentification.validators.UserValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigInteger;
import java.util.*;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RolesRepository rolesRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private DepartemntsRepository departemntsRepository;


    public Users save(Users user) {
        List<String> errors = UserValidator.validate(user);
        if (!errors.isEmpty()) {
            log.error("Utilisateur invalide {}", user);
            throw new InvalidEntityException("L'utilisateur n'est pas valide", ErrorCodes.UTILISATEUR_NOT_VALID, errors);
        }
        if (verifeCin(user.getNumCin())) {
            throw new InvalidEntityException("Un autre utilisateur avec le meme CIN existe deja", ErrorCodes.UTILISATEUR_ALREADY_EXISTS,
                    Collections.singletonList("Un autre utilisateur avec le meme CIN existe deja dans la BDD"));
        }
        if (verifeMail(user.getEmail())) {
            throw new InvalidEntityException("Un autre utilisateur avec le meme Email existe deja", ErrorCodes.UTILISATEUR_ALREADY_EXISTS,
                    Collections.singletonList("Un autre utilisateur avec le meme Email existe deja dans la BDD"));
        }
        if (verifeTel(user.getNumTel())) {
            throw new InvalidEntityException("Un autre utilisateur avec le meme numéro de téléphone existe deja", ErrorCodes.UTILISATEUR_ALREADY_EXISTS,
                    Collections.singletonList("Un autre utilisateur avec le meme numéro de téléphone existe deja dans la BDD"));
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        RecuperationNomDepartemnt(user);
        return userRepository.save(user);
    }

    public Map<String, BigInteger> countUsersByRole() {
        List<Object[]> results = userRepository.countUsersByRole();
        Map<String, BigInteger> countByRole = new HashMap<>();

        for (Object[] result : results) {
            String role = (String) result[0];
            BigInteger count = (BigInteger) result[1];
            countByRole.put(role, count);
        }
        return countByRole;
    }

    public List<Users> getAllUserByRoleName(String roleName) {
        return userRepository.findAllByRoleSet_RoleName(roleName);
    }


    public Users addAdmin(Users users) {
        Optional<Departemnts> departemnt = departemntsRepository.findByCodeDpartement("SAD");
        Roles adminRole = new Roles();
        adminRole.setRoleName("ADMIN");
        adminRole.setRoleDescription("Role par defaut pour les adminstrateures");
        Set<Roles> roles = new HashSet<>();
        roles.add(adminRole);
        users.setRoleSet(roles);
        users.setPassword("root");
        users.setDepartemnts(departemnt.get());
        return save(users);
    }

    public Users addChefDepartement(Users users) {
        Roles adminRole = new Roles();
        adminRole.setRoleName("CHEF");
        adminRole.setRoleDescription("Role par defaut por les chef du departemnts");
        Set<Roles> roles = new HashSet<>();
        roles.add(adminRole);
        users.setRoleSet(roles);
        users.setPassword("root");
        Long idChefDepartemnt = users.getDepartemnts().getDepartmentId();
        log.info("idChefDepartemnt{}",idChefDepartemnt);
        if(chefDepartementExiste(idChefDepartemnt) == true){
            throw new InvalidEntityException("Un Chef departemnt existe deja dans ce departemnt", ErrorCodes.UTILISATEUR_ALREADY_EXISTS,
                    Collections.singletonList("Un autre chef departemnt avec le meme departemnt existe deja dans la BDD"));
        }
        return save(users);
    }

    public Users addProfesseur(Users users) {
        Roles adminRole = new Roles();
        adminRole.setRoleName("PROF");
        adminRole.setRoleDescription("Role par defaut pour les professeurs");
        Set<Roles> roles = new HashSet<>();
        roles.add(adminRole);
        users.setRoleSet(roles);
        users.setPassword("root");
        return save(users);
    }

    public Users addTechnicien(Users users) {
        Roles adminRole = new Roles();
        adminRole.setRoleName("TECH");
        adminRole.setRoleDescription("Role par defaut pour les techniciens");
        Set<Roles> roles = new HashSet<>();
        roles.add(adminRole);
        users.setRoleSet(roles);
        users.setPassword("root");
        return save(users);
    }

    public Users updateUser(Long userId, Users updatedUser) {
        if (userId == null) {
            log.error("User ID is null");
            return null;
        }
        Optional<Users> user = userRepository.findById(userId);
        if (!user.isPresent()) {
            throw new EntityNotFoundException("Aucun User avec l' Id" + userId + "dans la base", ErrorCodes.UTILISATEUR_NOT_FOUND);
        }
        Users utilisateure = user.get();
        utilisateure.setNom(updatedUser.getNom());
        utilisateure.setPrenom(updatedUser.getPrenom());
        utilisateure.setNumCin(updatedUser.getNumCin());
        utilisateure.setDateNaissance(updatedUser.getDateNaissance());
        utilisateure.setEmail(updatedUser.getEmail());
        utilisateure.setPassword(updatedUser.getPassword());
        utilisateure.setNumTel(updatedUser.getNumTel());
        utilisateure.setAdresse(updatedUser.getAdresse());
        return userRepository.save(utilisateure);
    }

    public void deleteUser(Long userId) {
        if (userId == null) {
            log.error("User ID is null");
        }
        Users user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId,ErrorCodes.UTILISATEUR_NOT_FOUND));
        userRepository.delete(user);
    }

    public Users findUserById(Long userId) {
        if (userId == null) {
            log.error("User ID is null");
            return null;
        }
        Optional<Users> utilisateure = userRepository.findById(userId);
        return utilisateure.orElseThrow(() ->
                new EntityNotFoundException("Aucun User avec l' Id" + userId + "dans la base", ErrorCodes.UTILISATEUR_NOT_FOUND));
    }

    private boolean verifeCin(int numCin) {
        Optional<Users> user = userRepository.findByNumCin(numCin);
        return user.isPresent();
    }

    private boolean verifeMail(String email) {
        Optional<Users> user = userRepository.findByEmail(email);
        return user.isPresent();
    }

    private boolean verifeTel(String numTel) {
        Optional<Users> user = userRepository.findByNumTel(numTel);
        return user.isPresent();
    }

    public Users changerMotDePasse(ChangerMotDePasseUtilisateurDto dto) {
        validate(dto);
        Optional<Users> utilisateurOptional = userRepository.findById(dto.getId());
        if (utilisateurOptional.isEmpty()) {
            log.warn("Aucun utilisateur n'a ete trouve avec l'ID " + dto.getId());
            throw new EntityNotFoundException("Aucun utilisateur n'a ete trouve avec l'ID " + dto.getId(), ErrorCodes.UTILISATEUR_NOT_FOUND);
        }

        Users utilisateur = utilisateurOptional.get();
        utilisateur.setPassword(passwordEncoder.encode(dto.getMotDePasse()));
        return userRepository.save(utilisateur);
    }

    private void validate(ChangerMotDePasseUtilisateurDto dto) {
        if (dto == null) {
            log.warn("Impossible de modifier le mot de passe avec un objet NULL");
            throw new InvalidOperationException("Aucune information n'a ete fourni pour pouvoir changer le mot de passe",
                    ErrorCodes.UTILISATEUR_CHANGE_PASSWORD_OBJECT_NOT_VALID);
        }
        if (dto.getId() == null) {
            log.warn("Impossible de modifier le mot de passe avec un ID NULL");
            throw new InvalidOperationException("ID utilisateur null:: Impossible de modifier le mote de passe",
                    ErrorCodes.UTILISATEUR_CHANGE_PASSWORD_OBJECT_NOT_VALID);
        }
        if (!StringUtils.hasLength(dto.getMotDePasse()) || !StringUtils.hasLength(dto.getConfirmMotDePasse())) {
            log.warn("Impossible de modifier le mot de passe avec un mot de passe NULL");
            throw new InvalidOperationException("Mot de passe utilisateur null:: Impossible de modifier le mote de passe",
                    ErrorCodes.UTILISATEUR_CHANGE_PASSWORD_OBJECT_NOT_VALID);
        }
        if (!dto.getMotDePasse().equals(dto.getConfirmMotDePasse())) {
            log.warn("Impossible de modifier le mot de passe avec deux mots de passe different");
            throw new InvalidOperationException("Mots de passe utilisateur non conformes:: Impossible de modifier le mote de passe",
                    ErrorCodes.UTILISATEUR_CHANGE_PASSWORD_OBJECT_NOT_VALID);
        }
    }

    public Departemnts findByUserDepartemntId(Users users){
        Long idDepartemnt = users.getDepartemnts().getDepartmentId();
        Optional<Departemnts> optionalDepartemnts = departemntsRepository.findById(idDepartemnt);
        return optionalDepartemnts.get();
    }

    public void RecuperationNomDepartemnt(Users users){
        Departemnts departemnts = findByUserDepartemntId(users);
        users.setNomDepartement(departemnts.getNomDpartement());
    }

    public boolean chefDepartementExiste(Long idDepartemnt){
        Optional<Users> userOptional = userRepository.findByRoleSet_RoleNameAndDepartemnts_DepartmentId("CHEF",idDepartemnt);
        return userOptional.isPresent();
    }


}
