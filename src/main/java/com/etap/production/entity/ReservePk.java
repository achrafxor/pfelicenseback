package com.etap.production.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ReservePk implements Serializable {
    private Long id_puit;
    private Long id_produit;
}
