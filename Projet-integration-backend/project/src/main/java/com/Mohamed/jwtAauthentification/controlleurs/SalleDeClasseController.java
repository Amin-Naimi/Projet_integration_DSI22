package com.Mohamed.jwtAauthentification.controlleurs;

import com.Mohamed.jwtAauthentification.modals.Laboratoire;
import com.Mohamed.jwtAauthentification.modals.SalleDeClasse;
import com.Mohamed.jwtAauthentification.service.SalleDeClasseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emplacement/classe/")
public class SalleDeClasseController {

    @Autowired
    SalleDeClasseService salleDeClasseService;

    @PostMapping("/create")
    public ResponseEntity<SalleDeClasse> create(@RequestBody SalleDeClasse salleDeClasse) {
        SalleDeClasse createdSalleDeClasse = salleDeClasseService.create(salleDeClasse);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSalleDeClasse);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<SalleDeClasse> update(@PathVariable("id") Long id, @RequestBody SalleDeClasse salleDeClasseDetails) {
        SalleDeClasse updatedSalleDeClasse = salleDeClasseService.update(id, salleDeClasseDetails);
        return ResponseEntity.ok(updatedSalleDeClasse);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        salleDeClasseService.delete(id);
        return ResponseEntity.ok("Salle de classe: " +id+" deleted ");
    }

    @GetMapping("/all")
    public List<SalleDeClasse> getAllSalleDeClasse() {
        return salleDeClasseService.getAllSalleDeClasse();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<SalleDeClasse> getSalleDeClasseById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(salleDeClasseService.getSalleDClasseById(id));
    }

    @GetMapping("/filtre/{departmentId}")
    public List<SalleDeClasse> findAllByDepartemnts_DepartmentId(@PathVariable("departmentId") Long departmentId) {
        return salleDeClasseService.findAllSalleDClasseByDepId(departmentId);
    }

    @GetMapping("/count/{departmentId}")
    public int countByDepartmentId(@PathVariable("departmentId") Long departmentId) {
        return salleDeClasseService.countByDepartmentId(departmentId);
    }
}
