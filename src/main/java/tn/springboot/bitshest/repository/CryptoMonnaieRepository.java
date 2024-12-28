package tn.springboot.bitshest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.springboot.bitshest.entity.Cryptomoney;
import tn.springboot.bitshest.entity.Detailecryptomoney;

public interface CryptoMonnaieRepository extends JpaRepository<Cryptomoney, Long> {

}
