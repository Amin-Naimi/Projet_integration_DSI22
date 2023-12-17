package com.Mohamed.jwtAauthentification.controlleurs;

import com.Mohamed.jwtAauthentification.modals.Departemnts;
import com.Mohamed.jwtAauthentification.modals.Users;
import com.Mohamed.jwtAauthentification.service.DepartemntsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departements")
public class DepartemntsController {


    @Autowired
    private DepartemntsService departementService;

    @PostMapping("/create")
    public ResponseEntity<Departemnts> createDepartement(@RequestBody Departemnts departement) {
        return new ResponseEntity<>(departementService.createDepartement(departement), HttpStatus.CREATED);
    }

   // @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all")
    public List<Departemnts> getAllDepartments() {
        return departementService.getAllDepartments();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Departemnts> getDepartementById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(departementService.getDepartementById(id));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Departemnts> updateDepartemnt(@PathVariable("id") Long id,  @RequestBody Departemnts departemntDetails) {
        return new ResponseEntity<>(departementService.updateDepartement(id, departemntDetails), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDepartemnt(@PathVariable("id" )Long id) {
        departementService.deleteDepartement(id);
        return ResponseEntity.ok("Departemnt:" +id+" deleted ");
    }

    @GetMapping("/get/role/{roleName}/departemnt/{iddepa}")
    public ResponseEntity<List<Users>> getUsersByRoleAndDepartment(@PathVariable("roleName") String roleName, @PathVariable("iddepa") Long departmentId) {
        List<Users> users = departementService.getUsersByRoleAndDepartment(roleName, departmentId);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/count/role/department/{departmentId}")
    public ResponseEntity<Map<String, BigInteger>> countUsersByRoleAndDepartment(@PathVariable("departmentId") Long departmentId) {
        Map<String, BigInteger> countByRole = departementService.countUsersByRoleAndDepartment(departmentId);
        return ResponseEntity.ok(countByRole);
    }

    @GetMapping("/count")
    public long countDepartments() {
        return departementService.countDepartments();
    }

    @GetMapping("/users/department/{departmentId}")
    public ResponseEntity<List<Users>> findUsersByDepartmentId(@PathVariable Long departmentId) {
        List<Users> usersList = departementService.findUsersByDepartmentId(departmentId);
        return ResponseEntity.ok(usersList);
    }



}
