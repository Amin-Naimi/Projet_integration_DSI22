package com.Mohamed.jwtAauthentification.controlleurs;

import com.Mohamed.jwtAauthentification.modals.Emplacement;
import com.Mohamed.jwtAauthentification.service.EmplacemntService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Emplacemnt")
public class EmplacementController {
    @Autowired
    private EmplacemntService emplacementService;

    @PutMapping("/occupe/{id}")
    public Emplacement setEtatOccupe(@PathVariable Long id) {
        return emplacementService.setEtatOccupe(id);
    }

    @PutMapping("/enmaintenance/{id}")
    public Emplacement setEtatEnMaintenance(@PathVariable Long id) {
        return emplacementService.setEtatEnMaintenance(id);
    }

    @PutMapping("/ferme/{id}")
    public Emplacement setEtatFerme(@PathVariable Long id) {
        return emplacementService.setEtatFerme(id);
    }


}
