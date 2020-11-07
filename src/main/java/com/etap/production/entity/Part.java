package com.etap.production.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@NoArgsConstructor
@Data
@ToString
@EqualsAndHashCode
@Table(name = "part")
public class Part implements Serializable {
    @EmbeddedId
    private PartPk id;
    private Float part; 


    public Part(Float part, Concession concession, Tier tier) {
        this.part = part;

        this.concession = concession;
        this.tier = tier;
    }

    @ManyToOne
    @MapsId("idConcession")
    @JoinColumn(name = "idConcession")
    private Concession concession;

    @ManyToOne
    @MapsId("idTier")
    @JoinColumn(name = "idTier")
    private Tier tier;

    //getters and setters




    public Float getPart() {
        return part;
    }

    public void setPart(Float part) {
        this.part = part;
    } 



    public Concession getConcession() {
        return concession;
    }

    public void setConcession(Concession concession) {
        this.concession = concession;
    }

    public Tier getTier() {
        return tier;
    }

    public void setTier(Tier tier) {
        this.tier = tier;
    }
}
