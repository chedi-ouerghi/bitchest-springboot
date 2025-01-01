package tn.springboot.bitshest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tn.springboot.bitshest.entity.Administrateur;
import tn.springboot.bitshest.entity.Portefeuille;
import tn.springboot.bitshest.entity.Transactions;
import tn.springboot.bitshest.services.AdministrateurService;
import tn.springboot.bitshest.services.PortefeuilleService;
import tn.springboot.bitshest.services.TransactionsService;

import java.math.BigDecimal;
import java.nio.file.AccessDeniedException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bitchest/administrateurs")
// @CrossOrigin(origins = "*")
public class AdministrateurController {

    @Autowired
    private AdministrateurService administrateurService;

    @Autowired
    private PortefeuilleService portefeuilleService;

    @Autowired
    private TransactionsService transactionsService;

    // Gestionnaire d'erreurs pour les exceptions liées aux autorisations
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<String> handleAccessDeniedException(AccessDeniedException ex) {
        return new ResponseEntity<>("Accès refusé : " + ex.getMessage(), HttpStatus.FORBIDDEN);
    }
// valider
    // Méthode pour obtenir tous les administrateurs
    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')") 
    public ResponseEntity<List<Administrateur>> getAllAdministrateurs() {
        List<Administrateur> administrateurs = administrateurService.getAllAdministrateurs();
        return new ResponseEntity<>(administrateurs, HttpStatus.OK);
    }
// valider

    @GetMapping("/{loginId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')") 
    public ResponseEntity<Administrateur> getAdministrateurByLoginId(@PathVariable Long loginId) {
        Optional<Administrateur> administrateur = administrateurService.findByLoginId(loginId);
        return administrateur.map(admin -> new ResponseEntity<>(admin, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    // valider
    @GetMapping("/portfeuille/all")
    @PreAuthorize("hasRole('ROLE_ADMIN')") 
    public ResponseEntity<List<Portefeuille>> getAllPortefeuilles() {
        List<Portefeuille> portefeuilles = portefeuilleService.getAllPortefeuilles();
        return new ResponseEntity<>(portefeuilles, HttpStatus.OK);
    }

    // valider
    // Méthode pour obtenir les transactions par client
    @GetMapping("/client/{clientId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')") 
    public ResponseEntity<List<Transactions>> getTransactionsByClient(@PathVariable Long clientId) {
        List<Transactions> transactions = transactionsService.getTransactionsByClientId(clientId);
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }

    // valider
    // Méthode pour obtenir les transactions par type
    @GetMapping("/type/{typeTransaction}")
    @PreAuthorize("hasRole('ROLE_ADMIN')") 
    public ResponseEntity<List<Transactions>> getTransactionsByType(@PathVariable String typeTransaction) {
        List<Transactions> transactions = transactionsService.getTransactionsByType(typeTransaction);
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }

    // valider
    // Méthode pour obtenir les transactions par cryptomonnaie
    @GetMapping("/cryptomoney/{cryptomoneyId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')") 
    public ResponseEntity<List<Transactions>> getTransactionsByCryptomoney(@PathVariable Long cryptomoneyId) {
        List<Transactions> transactions = transactionsService.getTransactionsByCryptomoneyId(cryptomoneyId);
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }

    // valider
    // Méthode pour obtenir toutes les transactions avec détails de cryptomonnaie
    @GetMapping("/details")
    @PreAuthorize("hasRole('ROLE_ADMIN')") 
    public ResponseEntity<List<Transactions>> getAllWithCryptomoneyDetails() {
        List<Transactions> transactions = transactionsService.getAllTransactionsWithCryptomoneyDetails();
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }

    // valider
    // Méthode pour obtenir le total des ventes par client
    @GetMapping("/ventes/client/{clientId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')") 
    public ResponseEntity<BigDecimal> getTotalVentes(@PathVariable Long clientId) {
        BigDecimal totalVentes = transactionsService.getTotalVentesByClientId(clientId);
        return new ResponseEntity<>(totalVentes, HttpStatus.OK);
    }

    // valider
    // Méthode pour obtenir le total des achats par client
    @GetMapping("/achats/client/{clientId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')") 
    public ResponseEntity<BigDecimal> getTotalAchats(@PathVariable Long clientId) {
        BigDecimal totalAchats = transactionsService.getTotalAchatsByClientId(clientId);
        return new ResponseEntity<>(totalAchats, HttpStatus.OK);
    }

    // valider
    // Méthode pour obtenir les transactions par quantité
    @GetMapping("/quantite/{quantite}")
    @PreAuthorize("hasRole('ROLE_ADMIN')") 
    public ResponseEntity<List<Transactions>> getTransactionsByQuantite(@PathVariable BigDecimal quantite) {
        List<Transactions> transactions = transactionsService.getTransactionsByQuantiteGreaterThan(quantite);
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }
}
