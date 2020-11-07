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
@Table(name = "puit")
public class Puit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private @NonNull Long id_puit;
        private @NonNull String nom_puit;

    //constructor


    public Puit(@NonNull String nom_puit, Collection<LigneProduction> collection_puit, Concession concession_de_puit, Set<Reserve> reserve) {
        this.nom_puit = nom_puit;
        this.collection_puit = collection_puit;
        this.concession_de_puit = concession_de_puit;
        this.reserve = reserve;
    }

    //relations
    @JsonIgnore
    @OneToMany(mappedBy="puit_ligne_production",
            fetch=FetchType. LAZY, cascade=CascadeType.ALL)
    private Collection<LigneProduction> collection_puit;



    @ManyToOne
    @JoinColumn(name="id_concession",referencedColumnName = "id_concession")
    private Concession concession_de_puit;

    @JsonIgnore
    @OneToMany(mappedBy = "puit")
    private Set<Reserve> reserve = new HashSet<Reserve>();


    //getters and setters


    public Long getId_puit() {
        return id_puit;
    }

    public String getNom_puit() {
        return nom_puit;
    }

    public void setNom_puit(String nom_puit) {
        this.nom_puit = nom_puit;
    }

    public Collection<LigneProduction> getCollection_puit() {
        return collection_puit;
    }

    public void setCollection_puit(Collection<LigneProduction> collection_puit) {
        this.collection_puit = collection_puit;
    }

    public Concession getConcession_de_puit() {
        return concession_de_puit;
    }

    public void setConcession_de_puit(Concession concession_de_puit) {
        this.concession_de_puit = concession_de_puit;
    }

    public Set<Reserve> getReserve() {
        return reserve;
    }

    public void setReserve(Set<Reserve> reserve) {
        this.reserve = reserve;
    }
}
