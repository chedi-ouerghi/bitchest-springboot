package tn.springboot.bitshest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.springboot.bitshest.entity.Administrateur;
import tn.springboot.bitshest.entity.Portefeuille;
import tn.springboot.bitshest.services.AdministrateurService;
import tn.springboot.bitshest.services.PortefeuilleService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bitchest/administrateurs")
public class AdministrateurController {

    @Autowired
    private AdministrateurService administrateurService;

    @Autowired
    private PortefeuilleService portefeuilleService;

    
    
    // valdier
        // get all administrateurs 
    @GetMapping
    public ResponseEntity<List<Administrateur>> getAllAdministrateurs() {
        List<Administrateur> administrateurs = administrateurService.getAllAdministrateurs();
        return new ResponseEntity<>(administrateurs, HttpStatus.OK);
    }

    // valider
    // Afficher l'administrateur par ID du login
    @GetMapping("/{loginId}")
    public ResponseEntity<Administrateur> getAdministrateurByLoginId(@PathVariable Long loginId) {
        Optional<Administrateur> administrateur = administrateurService.findByLoginId(loginId);

        // Vérifie si l'administrateur existe
        return administrateur.map(admin -> new ResponseEntity<>(admin, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    // valdier
    // get all portefeuilles
       @GetMapping("/portfeuille/all")
       public ResponseEntity<List<Portefeuille>> getAllPortefeuilles() {
           List<Portefeuille> portefeuilles = portefeuilleService.getAllPortefeuilles();
           return ResponseEntity.ok(portefeuilles);

       }


       
}
