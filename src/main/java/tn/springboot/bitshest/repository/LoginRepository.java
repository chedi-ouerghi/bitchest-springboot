package tn.springboot.bitshest.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.springboot.bitshest.entity.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE Login l SET l.token = NULL")
    void clearTokens();

    Login findByEmail(String email);
}
