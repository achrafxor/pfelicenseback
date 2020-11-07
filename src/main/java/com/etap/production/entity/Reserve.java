package com.etap.production.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@Data
@ToString
@EqualsAndHashCode
@Table(name = "reserve")
public class Reserve implements Serializable {
    @EmbeddedId
    private ReservePk id;
    private Float Reserve;
    private Float qte_restante;

    //constructor   

    public Reserve(Float reserve, Float qte_restante, Puit puit, Produit produit) {
        Reserve = reserve;
        this.qte_restante = qte_restante;
        this.puit = puit;
        this.produit = produit;
    }

    @ManyToOne
    @MapsId("id_puit")
    @JoinColumn(name = "id_puit")
    private Puit puit;

    @ManyToOne
    @MapsId("id_produit")
    @JoinColumn(name = "id_produit")
    private Produit produit;

    public ReservePk getId() {
        return id;
    }



    public Float getReserve() {
        return Reserve;
    }

    public void setReserve(Float reserve) {
        Reserve = reserve;
    }

    public Float getQte_restante() {
        return qte_restante;
    }

    public void setQte_restante(Float qte_restante) {
        this.qte_restante = qte_restante;
    }

    public Puit getPuit() {
        return puit;
    }

    public void setPuit(Puit puit) {
        this.puit = puit;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }
}
