package com.etap.production.metier;

import com.etap.production.entity.Concession;
import com.etap.production.entity.Lieu;
import com.etap.production.entity.Puit;
import javassist.NotFoundException;
import org.springframework.http.ResponseEntity;

import java.util.Collection;

public interface InterfaceConcession {
    //concession crud
    public ResponseEntity<?> getConcession(Long concession_id) ;
    public Collection<Concession> getConcessionByName(String name);
    public void       addConcession(Concession concession,Long id);
    public ResponseEntity<?> updateConcession(Concession concession, Long concession_id, Long location_id);
    public void       deleteConcesson(Long concession_id);
    public Collection<Concession> listConcession();
}
