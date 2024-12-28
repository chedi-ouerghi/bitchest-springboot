package tn.springboot.bitshest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.springboot.bitshest.entity.Transactions;

import java.util.List;

@Repository
public interface TransactionsRepository extends JpaRepository<Transactions, Long> {

    // 1. Trouver par client ID
    List<Transactions> findByClientId(Long clientId);

    // 2. Trouver par type de transaction
    List<Transactions> findByTypeTransaction(String typeTransaction);

    // 3. Trouver par cryptomoney ID
    List<Transactions> findByCryptomoneyId(Long cryptomoneyId);
}
