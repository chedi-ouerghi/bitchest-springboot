package tn.springboot.bitshest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.springboot.bitshest.entity.Transactions;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface TransactionsRepository extends JpaRepository<Transactions, Long> {

    // 1. Trouver par client ID
    @Query("SELECT t FROM Transactions t WHERE t.client.id = ?1")
    List<Transactions> findByClientId(Long clientId);

    // 2. Trouver par type de transaction
    List<Transactions> findByTypeTransaction(String typeTransaction);

    // 3. Trouver par cryptomoney ID
    List<Transactions> findByCryptomoney_Id(Long cryptomoneyId);

    // 4. Récupérer toutes les transactions avec les détails de cryptomonnaie
    @Query("SELECT t FROM Transactions t JOIN t.detailecryptomoney dc JOIN t.cryptomoney cm")
    List<Transactions> findAllWithCryptomoneyDetails();

    // 5. Calculer la somme des ventes par client ID
    @Query("SELECT SUM(t.prixTransaction * t.quantite) FROM Transactions t WHERE t.typeTransaction = 'vente' AND t.client.id = ?1")
    BigDecimal sumVentesByClientId(Long clientId);

    // 6. Calculer la somme des achats par client ID
    @Query("SELECT SUM(t.prixTransaction * t.quantite) FROM Transactions t WHERE t.typeTransaction = 'achat' AND t.client.id = ?1")
    BigDecimal sumAchatsByClientId(Long clientId);

    // 7. Trouver les transactions avec une quantité supérieure à un certain seuil
    List<Transactions> findByQuantiteGreaterThan(BigDecimal quantite);
}
