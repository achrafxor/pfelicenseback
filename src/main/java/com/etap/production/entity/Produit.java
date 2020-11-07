package com.etap.production.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "produit")
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id_produit;

    private  String qualite;
    private  String type;
    private  int qte;

    //constructeur


    public Produit(String qualite, String type, int qte, Collection<LigneProduction> collection_produit, Set<Reserve> reserve) {
        this.qualite = qualite;
        this.type = type;
        this.qte = qte;
        this.collection_produit = collection_produit;
        this.reserve = reserve;
    }

    //relations
    @JsonIgnore
    @OneToMany(mappedBy="produit_ligne_production",
            fetch=FetchType. LAZY, cascade=CascadeType.ALL)
    private Collection<LigneProduction> collection_produit;
    @JsonIgnore
    @OneToMany(mappedBy = "produit")
    private Set<Reserve> reserve = new HashSet<Reserve>();





    //getters and setters


    public Long getId_produit() {
        return id_produit;
    }



    public String getQualite() {
        return qualite;
    }

    public void setQualite(String qualite) {
        this.qualite = qualite;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public Collection<LigneProduction> getCollection_produit() {
        return collection_produit;
    }

    public void setCollection_produit(Collection<LigneProduction> collection_produit) {
        this.collection_produit = collection_produit;
    }

    public Set<Reserve> getReserve() {
        return reserve;
    }

    public void setReserve(Set<Reserve> reserve) {
        this.reserve = reserve;
    }
}
