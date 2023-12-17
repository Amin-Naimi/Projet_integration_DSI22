package com.Mohamed.jwtAauthentification.controlleurs;

import com.Mohamed.jwtAauthentification.modals.*;
import com.Mohamed.jwtAauthentification.service.DemandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/demandes")
public class DemandeController {

    @Autowired
    DemandeService demandeService;

    @PostMapping("/create/reparation")
    public DemandeDeReparation creerDemandeDeReparation(@RequestBody DemandeDeReparation demande) {
        return demandeService.creerDemandeDeReparation(demande);
    }

    @PostMapping("/create/entretien")
    public DemandeDentretien creerDemandeDentretien(@RequestBody DemandeDentretien demande) {
        return demandeService.creerDemandeDentretien(demande);
    }

    @PostMapping("/create/fournitures")
    public DemandeDeFournitures creerDemandeDeFournitures(@RequestBody DemandeDeFournitures demande) {
        return demandeService.creerDemandeDeFournitures(demande);
    }

    @PostMapping("/create/assistancetechnique")
    public DemandeDassistanceTechnique creerDemandeDassistanceTechnique(@RequestBody DemandeDassistanceTechnique demande) {
        return demandeService.creerDemandeDassistanceTechnique(demande);
    }


    @PostMapping("/traitement/{id}/approuver")
    public Demande approuver(@PathVariable("id") Long id) {
        return demandeService.approuver(id);
    }

    @PostMapping("/traitement/{id}/rejeter")
    public Demande rejeter(@PathVariable("id") Long id) {
        return demandeService.rejeter(id);
    }

    @PostMapping("/traitement/{id}/commencerTraitement")
    public Demande commencerTraitement(@PathVariable("id") Long id) {
        return demandeService.commencerTraitement(id);
    }

    @PostMapping("/traitement/{id}/terminer")
    public Demande terminer(@PathVariable("id") Long id) {
        return demandeService.terminer(id);
    }


    @GetMapping("/department/{departmentId}")
    public ResponseEntity<List<Demande>> getDemandesByDepartmentId(@PathVariable Long departmentId) {
        List<Demande> demandes = demandeService.findAllByDepartments_DepartmentId(departmentId);
        return ResponseEntity.ok(demandes);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDemande(@PathVariable Long id) {
        demandeService.delete(id);
        return ResponseEntity.ok("Demande:" +id+" deleted ");
    }
}
