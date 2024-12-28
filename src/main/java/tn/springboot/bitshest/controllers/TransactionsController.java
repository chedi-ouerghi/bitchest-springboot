package tn.springboot.bitshest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.springboot.bitshest.entity.Transactions;
import tn.springboot.bitshest.services.TransactionsService;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionsController {

    @Autowired
    private TransactionsService transactionsService;

    // valider 
    // 1. Récupérer toutes les transactions par client ID
    @GetMapping("/client/{clientId}")
    public ResponseEntity<List<Transactions>> getTransactionsByClientId(@PathVariable Long clientId) {
        List<Transactions> transactions = transactionsService.getTransactionsByClientId(clientId);
        return ResponseEntity.ok(transactions);
    }

    // valider
    // 2. Récupérer toutes les transactions de type "achat"
    @GetMapping("/achat")
    public ResponseEntity<List<Transactions>> getAchatTransactions() {
        List<Transactions> transactions = transactionsService.getAchatTransactions();
        return ResponseEntity.ok(transactions);
    }

    // valider
    // 3. Récupérer toutes les transactions de type "vente"
    @GetMapping("/vente")
    public ResponseEntity<List<Transactions>> getVenteTransactions() {
        List<Transactions> transactions = transactionsService.getVenteTransactions();
        return ResponseEntity.ok(transactions);
    }

    // valider
    // 4. Récupérer toutes les transactions par cryptomoney ID
    @GetMapping("/cryptomoney/{cryptomoneyId}")
    public ResponseEntity<List<Transactions>> getTransactionsByCryptomoneyId(@PathVariable Long cryptomoneyId) {
        List<Transactions> transactions = transactionsService.getTransactionsByCryptomoneyId(cryptomoneyId);
        return ResponseEntity.ok(transactions);
    }
}
