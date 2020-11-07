package com.etap.production.metier;

import com.etap.production.entity.Lieu;
import com.etap.production.entity.Part;
import org.springframework.http.ResponseEntity;

import java.net.URISyntaxException;
import java.util.Collection;

public interface InterfacePart {
    public Collection<Part> getAllPart();
    public Part getPartBYId(Long id_Concession,Long id_Tier) ;
    public void addPart(Part part,Long id_Concession, Long id_tiers) throws URISyntaxException;
    public ResponseEntity<?> updatePart(Lieu location,Long location_id);
    public void deleteLocation(Long location_id);
}
