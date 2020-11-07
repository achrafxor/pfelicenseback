package com.etap.production.api;

import com.etap.production.entity.Concession;
import com.etap.production.entity.LigneProduction;
import com.etap.production.metier.ImplementationLigneProduction;
import com.etap.production.metier.InterfaceConcession;
import com.etap.production.metier.InterfaceLigneProduction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.Collection;

@CrossOrigin(origins = "*")
@RestController
    @RequestMapping("/Production")
public class ProductionLineApi {
    @Autowired
    private InterfaceLigneProduction interfaceLigneProduction;

    @GetMapping("/getProductionById/{id}")
    public ResponseEntity<?> getConcessionById(@PathVariable("id") Long id) {
        return interfaceLigneProduction.getProductionLineById(id);
    }
    @GetMapping("/all")
    public Collection<LigneProduction> all(){
        return interfaceLigneProduction.getALLProductionLine();
    }


    @PostMapping("/newProductionLine/{concession_id}/{product_id}/{well_id}")
    public ResponseEntity<?> addProduction(@RequestBody LigneProduction ligneproduction, @PathVariable("concession_id") Long concession_id, @PathVariable("product_id") Long product_id, @PathVariable("well_id") Long well_id) throws URISyntaxException {
        return interfaceLigneProduction.addProductionLine(ligneproduction, concession_id, product_id, well_id);
    }

    @PutMapping("/updateProductionLine/{production_id}/{concession_id}/{product_id}/{well_id}")
    public ResponseEntity<?> updateProduction(@RequestBody LigneProduction production_line, @PathVariable("production_id") Long production_id, @PathVariable("concession_id") Long concession_id, @PathVariable("product_id") Long product_id, @PathVariable("well_id") Long well_id) throws URISyntaxException {
        return interfaceLigneProduction.updateProductionLine(production_line, production_id, concession_id, product_id, well_id);
    }
    @DeleteMapping("/removeProductionLine/{id}")
    public void deleteconcession(@PathVariable("id") Long id) {

        interfaceLigneProduction.deleteProductionLine(id);
    }
}
