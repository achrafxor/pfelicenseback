package com.etap.production.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "tier")
public class Tier {
    //attributes

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id_tier;

    private String nom_tier;
    private String tel;



    //constructor


    public Tier(String nom_tier, String tel,  Set<Part> part,Lieu lieu_de_tier) {
        this.nom_tier = nom_tier;
        this.tel = tel;
        this.lieu_de_tier=lieu_de_tier;
        this.part = part;
    }

    public Lieu getLieu_de_tier() {
        return lieu_de_tier;
    }

    public void setLieu_de_tier(Lieu lieu_de_tier) {
        this.lieu_de_tier = lieu_de_tier;
    }

    //relations
    @JsonIgnore
    @OneToMany(mappedBy = "tier")
    private Set<Part> part = new HashSet<Part>();

    @ManyToOne
    @JoinColumn(name="id_lieu",referencedColumnName = "id_lieu")
    private Lieu lieu_de_tier;

    //getters and setters


    public Long getId_tier() {
        return id_tier;
    }



    public String getNom_tier() {
        return nom_tier;
    }

    public void setNom_tier(String nom_tier) {
        this.nom_tier = nom_tier;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }





    public Set<Part> getPart() {
        return part;
    }

    public void setPart(Set<Part> part) {
        this.part = part;
    }
}
