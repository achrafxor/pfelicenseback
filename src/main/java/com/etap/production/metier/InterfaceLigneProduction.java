package com.etap.production.metier;

import com.etap.production.entity.Concession;
import com.etap.production.entity.LigneProduction;
import com.etap.production.entity.Produit;
import org.springframework.http.ResponseEntity;

import java.net.URISyntaxException;
import java.util.Collection;

public interface InterfaceLigneProduction {
    public Collection<LigneProduction> getALLProductionLine();
    public ResponseEntity<?> getProductionLineById(Long id) ;
    public ResponseEntity<?> addProductionLine(LigneProduction productionline, Long concession_id, Long product_id,Long well_id) throws URISyntaxException;
    public ResponseEntity<?> updateProductionLine(LigneProduction productionline,Long production_id, Long concession_id, Long product_id,Long well_id);
    public void deleteProductionLine(Long id);
}
