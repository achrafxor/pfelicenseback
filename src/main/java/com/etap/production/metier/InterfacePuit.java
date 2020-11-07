package com.etap.production.metier;

import com.etap.production.entity.LigneProduction;
import com.etap.production.entity.Puit;
import org.springframework.http.ResponseEntity;

import java.net.URISyntaxException;
import java.util.Collection;

public interface InterfacePuit {
    public Collection<Puit> getAllwell();
    public ResponseEntity<?> getWellById(Long id) ;
    public ResponseEntity<?> addWell(Puit well, Long concession_id) throws URISyntaxException;
    public ResponseEntity<?> updateWell(Puit well,Long well_id, Long woncession_id);
    public void deleteWell(Long id);
}
