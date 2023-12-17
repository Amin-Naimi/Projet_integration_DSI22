package com.Mohamed.jwtAauthentification.controlleurs;

import com.Mohamed.jwtAauthentification.modals.Departemnts;
import com.Mohamed.jwtAauthentification.modals.Emplacement;
import com.Mohamed.jwtAauthentification.modals.Laboratoire;
import com.Mohamed.jwtAauthentification.service.LaboratoireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emplacement/laboratoire")
public class LaboratoireContoller {

    @Autowired
    private LaboratoireService laboratoireService;

    @PostMapping("/create")
    public ResponseEntity<Laboratoire> create(@RequestBody Laboratoire laboratoire) {
        Laboratoire createdLaboratoire = laboratoireService.create(laboratoire);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdLaboratoire);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Laboratoire> update(@PathVariable("id") Long id, @RequestBody Laboratoire laboratoireDetails) {
        Laboratoire updatedLaboratoire = laboratoireService.update(id, laboratoireDetails);
        return ResponseEntity.ok(updatedLaboratoire);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        laboratoireService.delete(id);
        return ResponseEntity.ok("labo:" +id+" deleted ");
    }

    @GetMapping("/all")
    public List<Laboratoire> getAllLaboratoires() {
        return laboratoireService.getAllLaboratoires();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Laboratoire> getLaboratoireById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(laboratoireService.getLaboratoireById(id));
    }

    @GetMapping("/filtre/{departmentId}")
    public List<Laboratoire> findAllByDepartemnts_DepartmentId(@PathVariable("departmentId") Long departmentId) {
        return laboratoireService.findAllLaboByDepId(departmentId);
    }

    @GetMapping("/count/{departmentId}")
    public int countByDepartmentId(@PathVariable("departmentId") Long departmentId) {
        return laboratoireService.countByDepartmentId(departmentId);
    }
}


