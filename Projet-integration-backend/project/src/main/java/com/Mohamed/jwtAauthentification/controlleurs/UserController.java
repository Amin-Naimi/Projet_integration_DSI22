package com.Mohamed.jwtAauthentification.controlleurs;

import com.Mohamed.jwtAauthentification.dto.ChangerMotDePasseUtilisateurDto;
import com.Mohamed.jwtAauthentification.modals.Users;
import com.Mohamed.jwtAauthentification.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create/admin")
    public Users createNewAdmin(@RequestBody Users users){
        return userService.addAdmin(users);
    }

    @PostMapping("/create/chef")
    public Users createNewChefDepartement(@RequestBody Users users){
        return userService.addChefDepartement(users);
    }

    @PostMapping("/create/prof")
    public Users createNewProfesseur(@RequestBody Users users){
        return userService.addProfesseur(users);
    }

    @PostMapping("/create/tech")
    public Users createNewTechnicien(@RequestBody Users users){
        return userService.addTechnicien(users);
    }

    @GetMapping("/all")
    public List<Users>getAllUserByRoleName(@RequestParam String roleName){
        return userService.getAllUserByRoleName(roleName);
    }

    @GetMapping("/countByRole")
    public ResponseEntity<Map<String, BigInteger>> countUsersByRole() {
        Map<String, BigInteger> countByRole = userService.countUsersByRole();
        return ResponseEntity.ok(countByRole);
    }


    @PutMapping("/update/{userId}")
    public ResponseEntity<Users> updateUser(@PathVariable("userId") Long userId, @RequestBody Users updatedUser) {
        Users user = userService.updateUser(userId, updatedUser);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok("user:" +userId+" deleted ");
    }

    @GetMapping("/finduser/{userId}")
    public Users findUserById(@PathVariable("userId") Long userId){
        return this.userService.findUserById(userId);
    }

    @PutMapping("/changermotdepasse/userId/{id}")
    public ResponseEntity<Users> changerMotDePasse(@PathVariable Long id, @RequestBody ChangerMotDePasseUtilisateurDto dto) {
        dto.setId(id);
        Users updatedUser = userService.changerMotDePasse(dto);
        return ResponseEntity.ok(updatedUser);
    }

    @GetMapping("/chefDepartement/{idDepartemnt}")
    public Boolean chefDepartementExiste(@PathVariable("idDepartemnt") Long idDepartemnt) {
        return userService.chefDepartementExiste(idDepartemnt);
    }
}

