package com.etap.production.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "lieu")
public class Lieu {

    //attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id_lieu;

    private  String pays;
    private  String region;
    private  String zip_code;

    //constructor


    public Lieu(String pays, String region, String zip_code, Collection<Concession> concessionCollection) {
        this.pays = pays;
        this.region = region;
        this.zip_code = zip_code;
        this.concessionCollection = concessionCollection;
    }

    //relations
    @JsonIgnore
    @OneToMany(mappedBy="lieu_de_concession",
            fetch=FetchType. LAZY, cascade=CascadeType.ALL)
    private Collection<Concession> concessionCollection;
    @JsonIgnore
    @OneToMany(mappedBy="lieu_de_tier",
            fetch=FetchType. LAZY, cascade=CascadeType.ALL)
    private Collection<Tier> lieuTier;
    //getters and setters

    public Long getId_lieu() {
        return id_lieu;
    }
    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    public Collection<Concession> getConcessionCollection() {
        return concessionCollection;
    }

    public void setConcessionCollection(Collection<Concession> concessionCollection) {
        this.concessionCollection = concessionCollection;
    }
}
