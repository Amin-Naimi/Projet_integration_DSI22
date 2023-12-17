package com.Mohamed.jwtAauthentification.controlleurs;

import com.Mohamed.jwtAauthentification.modals.Materiel;
import com.Mohamed.jwtAauthentification.service.MaterielService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/materiel")
public class MaterielController {

    @Autowired
    private MaterielService materielService;

    @PostMapping("/add")
    public Materiel addMateril(@RequestBody Materiel materiel){
        return materielService.saveMateriel(materiel);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Materiel> updateMateriel(@PathVariable("id")Long id, @RequestBody Materiel materielDetails) {
        Materiel updatedMateriel = materielService.update(id, materielDetails);
        return ResponseEntity.ok(updatedMateriel);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMateriel(@PathVariable("id") Long id) {
        materielService.delete(id);
        return ResponseEntity.ok("Materiel: " +id+" deleted ");
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<Materiel>> getAllMateriels() {
        List<Materiel> materiels = materielService.getAllMateriel();
        return ResponseEntity.ok(materiels);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Materiel> getMaterielById(@PathVariable Long id) {
        Materiel materiel = materielService.getMaterielById(id);
        return ResponseEntity.ok(materiel);
    }

    @GetMapping("/labo/{laboId}")
    public ResponseEntity<List<Materiel>> findAllMatByLaboId(@PathVariable Long laboId) {
        List<Materiel> materiels = materielService.findAllMatByLaboId(laboId);
        return ResponseEntity.ok(materiels);
    }

    @GetMapping("/get/{numeroSerie}")
    public ResponseEntity<Materiel> getMaterielByNumeroSerie(@PathVariable String numeroSerie) {
        Materiel materiel = materielService.findMaterielByNumeroSerie(numeroSerie);
        return ResponseEntity.ok(materiel);
    }

    @PutMapping("/enservice/{id}")
    public ResponseEntity<Materiel> setEtatEnService(@PathVariable Long id) {
        Materiel updatedMateriel = materielService.setEtatEnService(id);
        return ResponseEntity.ok(updatedMateriel);
    }

    @PutMapping("/enreparation/{id}")
    public ResponseEntity<Materiel> setEtatEnReparation(@PathVariable Long id) {
        Materiel updatedMateriel = materielService.setEtatEnReparation(id);
        return ResponseEntity.ok(updatedMateriel);
    }

    @PutMapping("/enrupturestock/{id}")
    public ResponseEntity<Materiel> setEtatEnRuptureStock(@PathVariable Long id) {
        Materiel updatedMateriel = materielService.setEtatEnRuptureStock(id);
        return ResponseEntity.ok(updatedMateriel);
    }

}
