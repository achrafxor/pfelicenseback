package com.etap.production.entity;

import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
public class PartPk implements Serializable {
    private Long idConcession;
    private Long idTier;


    public Long getIdConcession() {
        return idConcession;
    }

    public void setIdConcession(Long idConcession) {
        this.idConcession = idConcession;
    }

    public Long getIdTier() {
        return idTier;
    }

    public void setIdTier(Long idTier) {
        this.idTier = idTier;
    }

    public PartPk(Long idConcession, Long idTier) {
        this.idConcession = idConcession;
        this.idTier = idTier;
    }
}
