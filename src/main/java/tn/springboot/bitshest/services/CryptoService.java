package tn.springboot.bitshest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.springboot.bitshest.entity.Cryptomoney;
import tn.springboot.bitshest.entity.Detailecryptomoney;
import tn.springboot.bitshest.repository.CryptoMonnaieRepository;
import tn.springboot.bitshest.repository.DetailecryptomoneyRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class CryptoService {

    @Autowired
    private CryptoMonnaieRepository cryptomoneyRepository;

    @Autowired
    private DetailecryptomoneyRepository detailecryptomoneyRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // valider
    @Transactional
    public String vendreCrypto(Long clientId, Long cryptoMoneyId, Long detailCryptoMoneyId, BigDecimal quantite) {
        try {

            String sql = "{CALL VendreCrypto(?, ?, ?, ?)}";
            jdbcTemplate.update(sql, clientId, cryptoMoneyId, detailCryptoMoneyId, quantite);

            return "Vente réussie";

        } catch (Exception e) {
            // Gérer l'exception si la vente échoue
            throw new RuntimeException("Erreur lors de la vente de la cryptomonnaie: " + e.getMessage(), e);
        }
    }

    // valdier
    // Get all Cryptomoney
    public List<Cryptomoney> getAllCryptomoney() {
        return cryptomoneyRepository.findAll();
    }

    // valdier
    // Get Cryptomoney by ID
    public Optional<Cryptomoney> getCryptomoneyById(Long id) {
        return cryptomoneyRepository.findById(id);
    }

    // valdier
    // Get details of Cryptomoney by ID
    public List<Detailecryptomoney> getDetailsByCryptomoneyId(Long id) {
        return detailecryptomoneyRepository.findByCryptomoney_Id(id);
    }
}
