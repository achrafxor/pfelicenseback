package com.etap.production.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
//import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "concession")
public class Concession  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private   Long id_concession;

    private String nom_concession;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private  Date date_ouverture;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private  Date date_cloture;

    //constructor

    public Concession( String nom_concession, Date date_ouverture, Date date_cloture, Lieu lieu_de_concession, Collection<LigneProduction> collection_concession, Collection<Puit> liste_puit_du_concession, Set<Part> part) {

        this.nom_concession = nom_concession;
        this.date_ouverture = date_ouverture;
        this.date_cloture = date_cloture;
        this.lieu_de_concession = lieu_de_concession;
        this.collection_concession = collection_concession;
        this.liste_puit_du_concession = liste_puit_du_concession;
        this.part = part;
    }

    //relations verified step1
    @ManyToOne
    @JoinColumn(name="id_lieu",referencedColumnName = "id_lieu")
    private Lieu lieu_de_concession;

    @JsonIgnore
    @OneToMany(mappedBy="concession_ligne_production",
            fetch=FetchType. LAZY, cascade=CascadeType.ALL)

    private Collection<LigneProduction> collection_concession;
    @JsonIgnore
    @OneToMany(mappedBy="concession_de_puit",
            fetch=FetchType. LAZY, cascade=CascadeType.ALL)
    private Collection<Puit> liste_puit_du_concession;
    @JsonIgnore
    @OneToMany(mappedBy = "concession")
    private Set<Part> part = new HashSet<Part>();


    //getters and setters


    public Long getId_concession() {
        return id_concession;
    }



    public String getNom_concession() {
        return nom_concession;
    }

    public void setNom_concession(String nom_concession) {
        this.nom_concession = nom_concession;
    }

    public Date getDate_ouverture() {
        return date_ouverture;
    }

    public void setDate_ouverture(Date date_ouverture) {
        this.date_ouverture = date_ouverture;
    }

    public Date getDate_cloture() {
        return date_cloture;
    }

    public void setDate_cloture(Date date_cloture) {
        this.date_cloture = date_cloture;
    }

    public Lieu getLieu_de_concession() {
        return lieu_de_concession;
    }

    public void setLieu_de_concession(Lieu lieu_de_concession) {
        this.lieu_de_concession = lieu_de_concession;
    }

    public Collection<LigneProduction> getCollection_concession() {
        return collection_concession;
    }

    public void setCollection_concession(Collection<LigneProduction> collection_concession) {
        this.collection_concession = collection_concession;
    }

    public Collection<Puit> getListe_puit_du_concession() {
        return liste_puit_du_concession;
    }

    public void setListe_puit_du_concession(Collection<Puit> liste_puit_du_concession) {
        this.liste_puit_du_concession = liste_puit_du_concession;
    }

    public Set<Part> getPart() {
        return part;
    }

    public void setPart(Set<Part> part) {
        this.part = part;
    }
}
