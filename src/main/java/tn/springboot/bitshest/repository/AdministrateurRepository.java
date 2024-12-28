package tn.springboot.bitshest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.springboot.bitshest.entity.Administrateur;

import java.util.Optional;

@Repository
public interface AdministrateurRepository extends JpaRepository<Administrateur, Long> {

    // Recherche d'un administrateur par l'ID du login
    Optional<Administrateur> findByLogin_Id(Long loginId);
}
