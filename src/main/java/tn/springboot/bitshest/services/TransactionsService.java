package tn.springboot.bitshest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.springboot.bitshest.entity.Transactions;
import tn.springboot.bitshest.repository.TransactionsRepository;

import java.util.List;

@Service
public class TransactionsService {

    @Autowired
    private TransactionsRepository transactionsRepository;

    // 1. Récupérer toutes les transactions par client ID
    public List<Transactions> getTransactionsByClientId(Long clientId) {
        return transactionsRepository.findByClientId(clientId);
    }

    // 2. Récupérer toutes les transactions de type "achat"
    public List<Transactions> getAchatTransactions() {
        return transactionsRepository.findByTypeTransaction("achat");
    }

    // 3. Récupérer toutes les transactions de type "vente"
    public List<Transactions> getVenteTransactions() {
        return transactionsRepository.findByTypeTransaction("vente");
    }

    // 4. Récupérer toutes les transactions par cryptomoney ID
    public List<Transactions> getTransactionsByCryptomoneyId(Long cryptomoneyId) {
        return transactionsRepository.findByCryptomoneyId(cryptomoneyId);
    }
}
