package tn.springboot.bitshest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.springboot.bitshest.entity.Administrateur;
import tn.springboot.bitshest.repository.AdministrateurRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AdministrateurService {

    @Autowired
    private AdministrateurRepository administrateurRepository;

    // Méthode pour récupérer un administrateur par login ID
    public Optional<Administrateur> findByLoginId(Long loginId) {
        return administrateurRepository.findByLogin_Id(loginId);
    }
    
    public List<Administrateur> getAllAdministrateurs() {
        return administrateurRepository.findAll();
    }
}
