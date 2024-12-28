package tn.springboot.bitshest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.springboot.bitshest.entity.Detailecryptomoney;

public interface DetailecryptomoneyRepository extends JpaRepository<Detailecryptomoney, Long> {
    List<Detailecryptomoney> findByCryptomoney_Id(Long id);
    
}
