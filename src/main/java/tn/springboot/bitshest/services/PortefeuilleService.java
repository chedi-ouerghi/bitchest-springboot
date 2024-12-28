package tn.springboot.bitshest.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.springboot.bitshest.entity.Portefeuille;
import tn.springboot.bitshest.repository.PortefeuilleRepository;

@Service
public class PortefeuilleService {

    @Autowired
    private PortefeuilleRepository portefeuilleRepository;

 
    
    // Obtenir tous les portefeuilles
    public List<Portefeuille> getAllPortefeuilles() {
        return portefeuilleRepository.findAll();
    }


    // Obtenir l'historique des portefeuilles d'un client par son ID
    public List<Portefeuille> getPortefeuilleByClientId(Long clientId) {
        return portefeuilleRepository.findByClientId(clientId);
    }

}
