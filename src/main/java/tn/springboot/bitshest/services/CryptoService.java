package tn.springboot.bitshest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import tn.springboot.bitshest.entity.Cryptomoney;
import tn.springboot.bitshest.entity.Detailecryptomoney;
import tn.springboot.bitshest.repository.CryptoMonnaieRepository;
import tn.springboot.bitshest.repository.DetailecryptomoneyRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CryptoService {

    @Autowired
    private CryptoMonnaieRepository cryptomoneyRepository;

    @Autowired
    private DetailecryptomoneyRepository detailecryptomoneyRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;


    private final RestTemplate restTemplate = new RestTemplate();
    private static final String API_URL = "https://api.coingecko.com/api/v3/coins/";

    // valider
    public String addCrypto(String cryptoId) {
        try {
            String url = API_URL + cryptoId.toLowerCase();
            CryptoApiResponse response = restTemplate.getForObject(url, CryptoApiResponse.class);

            if (response == null) {
                return "Crypto non trouvée : " + cryptoId;
            }

            // Add to Cryptomoney table
            Cryptomoney crypto = new Cryptomoney();
            crypto.setNom(response.getName());
            crypto = cryptomoneyRepository.save(crypto);

            // Add to Detailecryptomoney table
            Detailecryptomoney details = new Detailecryptomoney();
            details.setCoursActuel(response.getMarketData().getCurrentPrice().get("eur"));
                                                                                          
            details.setSymbole(response.getSymbol());
            details.setVariation24h(BigDecimal.valueOf(response.getMarketData().getPriceChangePercentage24h()));
                                                                                                                
                                                                                                                
            details.setDateMiseAJour(LocalDateTime.now());
            details.setCryptomoney(crypto);

            detailecryptomoneyRepository.save(details);

            return "Crypto ajoutée avec succès : " + response.getName();

        } catch (Exception e) {
            return "Erreur lors de l'ajout : " + e.getMessage();
        }
    }
    // valider
    @Transactional
    public String vendreCrypto(Long clientId, Long cryptoMoneyId, Long detailCryptoMoneyId, BigDecimal quantite) {
        try {

            String sql = "{CALL VendreCrypto(?, ?, ?, ?)}";
            jdbcTemplate.update(sql, clientId, cryptoMoneyId, detailCryptoMoneyId, quantite);

            return "Vente réussie";

        } catch (Exception e) {
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
