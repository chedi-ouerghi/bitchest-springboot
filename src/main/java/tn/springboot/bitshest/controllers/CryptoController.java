package tn.springboot.bitshest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tn.springboot.bitshest.entity.Cryptomoney;
import tn.springboot.bitshest.entity.Detailecryptomoney;
import tn.springboot.bitshest.services.CryptoService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/crypto")
public class CryptoController {

    @Autowired
    private CryptoService cryptoService;

    // valider

    // p_detailecryptomoney_id; -- v_prix = 67500.50 //  v vente=p quantite×v prix => -- v_vente = 0.01 * 67500.50 = 675.005 // v nouveau solde=v solde+v vente =>-- v_nouveau_solde = 500 + 675.005 = 1175.005 
    @PostMapping("/vendre")
    public ResponseEntity<String> vendreCrypto(
            @RequestParam Long clientId,
            @RequestParam Long cryptoMoneyId,
            @RequestParam Long detailCryptoMoneyId,
            @RequestParam BigDecimal quantite) {

        try {
            String result = cryptoService.vendreCrypto(clientId, cryptoMoneyId, detailCryptoMoneyId, quantite);
            return ResponseEntity.ok(result);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("Erreur: " + e.getMessage());
        }
    }


     @Autowired
    private CryptoService cryptomoneyService;

    // valdier
    // Get all Cryptomoney
    @GetMapping("/all")
    public ResponseEntity<List<Cryptomoney>> getAllCryptomoney() {
        List<Cryptomoney> cryptomoneyList = cryptomoneyService.getAllCryptomoney();
        return ResponseEntity.ok(cryptomoneyList);
    }

// valdier
// Get Cryptomoney by ID
    @GetMapping("/{id}")
    public ResponseEntity<Cryptomoney> getCryptomoneyById(@PathVariable Long id) {
        Optional<Cryptomoney> cryptomoney = cryptomoneyService.getCryptomoneyById(id);
        return cryptomoney.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


// valdier 
    // Get details by Cryptomoney ID
    @GetMapping("/{id}/details")
    public ResponseEntity<List<Detailecryptomoney>> getDetailsByCryptomoneyId(@PathVariable Long id) {
        List<Detailecryptomoney> details = cryptomoneyService.getDetailsByCryptomoneyId(id);
        if (details.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(details);
    }


    @PostMapping("/add")
    public ResponseEntity<?> addCrypto(@RequestParam String cryptoId) {
        String message = cryptoService.addCrypto(cryptoId);
        return ResponseEntity.ok().body(new ResponseMessage(message));
    }

    public static class ResponseMessage {
        private String message;

        public ResponseMessage(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
    
}
