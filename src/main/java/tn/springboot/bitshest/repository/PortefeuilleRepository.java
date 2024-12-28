package tn.springboot.bitshest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.springboot.bitshest.entity.Portefeuille;

public interface PortefeuilleRepository extends JpaRepository<Portefeuille, Long> {
    List<Portefeuille> findByClientId(Long clientId);
}
