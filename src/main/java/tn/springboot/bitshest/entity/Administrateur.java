package tn.springboot.bitshest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.time.LocalDateTime;

@Entity
public class Administrateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dernierAcces;
    private String email;
    private String nom;

    @ManyToOne
    @JoinColumn(name = "login_id")
    private Login login;

    // Constructeurs
    public Administrateur() {
    }

    public Administrateur(Long id, LocalDateTime dernierAcces, String email, String nom, Login login) {
        this.id = id;
        this.dernierAcces = dernierAcces;
        this.email = email;
        this.nom = nom;
        this.login = login;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

/*************  ✨ Codeium Command ⭐  *************/
/******  f1a02cf9-76c6-4507-983a-4e56ce2179ca  *******/
    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDernierAcces() {
        return dernierAcces;
    }

    public void setDernierAcces(LocalDateTime dernierAcces) {
        this.dernierAcces = dernierAcces;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
}
