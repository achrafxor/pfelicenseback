package com.etap.production.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "ligne_production")
public class LigneProduction {
    //attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_ligne;

    private int qte;
    private int cout;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date date;

    //constructor


    public LigneProduction(int qte, int cout, Date date, Produit produit_ligne_production, Concession concession_ligne_production, Puit puit_ligne_production) {
        this.qte = qte;
        this.cout = cout;
        this.date = date;
        this.produit_ligne_production = produit_ligne_production;
        this.concession_ligne_production = concession_ligne_production;
        this.puit_ligne_production = puit_ligne_production;
    }

    //make relations
    //make a foreign key and return an object of produit ,concession and puit

    @ManyToOne
    @JoinColumn(name="id_produit",referencedColumnName = "id_produit")
    private Produit produit_ligne_production;


    @ManyToOne
    @JoinColumn(name="id_concession",referencedColumnName = "id_concession")
    private Concession concession_ligne_production;


    @ManyToOne
    @JoinColumn(name="id_puit",referencedColumnName = "id_puit")
    private Puit puit_ligne_production;

    //getters and setters


    public Long getId_ligne() {
        return id_ligne;
    }
    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public int getCout() {
        return cout;
    }

    public void setCout(int cout) {
        this.cout = cout;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Produit getProduit_ligne_production() {
        return produit_ligne_production;
    }

    public void setProduit_ligne_production(Produit produit_ligne_production) {
        this.produit_ligne_production = produit_ligne_production;
    }

    public Concession getConcession_ligne_production() {
        return concession_ligne_production;
    }

    public void setConcession_ligne_production(Concession concession_ligne_production) {
        this.concession_ligne_production = concession_ligne_production;
    }

    public Puit getPuit_ligne_production() {
        return puit_ligne_production;
    }

    public void setPuit_ligne_production(Puit puit_ligne_production) {
        this.puit_ligne_production = puit_ligne_production;
    }
}
