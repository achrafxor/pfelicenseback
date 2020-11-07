package com.etap.production.api;

import com.etap.production.entity.LigneProduction;
import com.etap.production.entity.Puit;
import com.etap.production.metier.ImplementationPuit;
import com.etap.production.metier.InterfaceConcession;
import com.etap.production.metier.InterfacePuit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.Collection;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/well")

public class WellAPi {
    @Autowired
    private InterfacePuit interfacewell;

    @GetMapping("/all")
    public Collection<Puit> getAllWell() {
        return interfacewell.getAllwell();
    }

    @GetMapping("/getWellById/{id}")
    public ResponseEntity<?> getWellById(@PathVariable("id") Long id) {
        return interfacewell.getWellById(id);
    }

    @PostMapping("/addWell/{concession_id}")
    public ResponseEntity<?> addWell(@RequestBody Puit well, @PathVariable("concession_id") Long concession_id) throws URISyntaxException {
        return interfacewell.addWell(well, concession_id);
    }
    @PutMapping("/updateWell/{well_id}/{concession_id}")
    public ResponseEntity<?> updateWell(@RequestBody Puit well,@PathVariable("well_id") Long well_id,@PathVariable("concession_id") Long concession_id) {
        return interfacewell.updateWell(well,well_id,concession_id);
    }
    @DeleteMapping("/deleteWell/{id}")
    public void deleteWell(@PathVariable("id") Long id){
        interfacewell.deleteWell(id);
    }
}