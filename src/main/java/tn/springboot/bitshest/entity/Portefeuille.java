package tn.springboot.bitshest.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "portefeuille") // Correspondance avec la table SQL
public class Portefeuille {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "prix", nullable = false, precision = 15, scale = 2)
    private BigDecimal prix;

    @Column(name = "date_miseajour", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime dateMiseAJour;

    @Column(name = "achat", precision = 15, scale = 2, nullable = false)
    private BigDecimal achat = BigDecimal.ZERO;

    @Column(name = "vente", precision = 15, scale = 2, nullable = false)
    private BigDecimal vente = BigDecimal.ZERO;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    // Constructeurs
    public Portefeuille() {
    }

    public Portefeuille(BigDecimal prix, LocalDateTime dateMiseAJour, BigDecimal achat, BigDecimal vente,
            Client client) {
        this.prix = prix;
        this.dateMiseAJour = dateMiseAJour;
        this.achat = achat;
        this.vente = vente;
        this.client = client;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }

    public LocalDateTime getDateMiseAJour() {
        return dateMiseAJour;
    }

    public void setDateMiseAJour(LocalDateTime dateMiseAJour) {
        this.dateMiseAJour = dateMiseAJour;
    }

    public BigDecimal getAchat() {
        return achat;
    }

    public void setAchat(BigDecimal achat) {
        this.achat = achat;
    }

    public BigDecimal getVente() {
        return vente;
    }

    public void setVente(BigDecimal vente) {
        this.vente = vente;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
