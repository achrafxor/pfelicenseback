package com.etap.production.api;

import com.etap.production.entity.Tier;
import com.etap.production.metier.InterfaceTier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.Collection;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Tier")
public class ShareholderApi {
    @Autowired
    private InterfaceTier interfaceTier;

    @GetMapping("/all")
    public Collection<Tier> getAllShareHolders(){
        return interfaceTier.getAllShareHolders();
    }
    @GetMapping("/all/{id}")
    public ResponseEntity<?> getShareHoldersById(@PathVariable("id") Long id){
        return interfaceTier.getShareHoldersById(id);
    }
    @PostMapping("/addTier/{lieu_id}")
    public ResponseEntity<?> addShareHolder(@RequestBody  Tier shareholder,@PathVariable("lieu_id") Long lieu_id) throws URISyntaxException {
        return interfaceTier.addShareHolder(shareholder,lieu_id);
    }
    @PutMapping("/updateTier/{shareholder_id}/{lieu_id}")
    public ResponseEntity<?> updateShareHolder(@RequestBody Tier shareholder,@PathVariable("shareholder_id") Long shareholder_id,@PathVariable("lieu_id") Long lieu_id) {
        return interfaceTier.updateShareHolder(shareholder,shareholder_id,lieu_id);
    }
    @DeleteMapping("/delete")
    public void deleteShareHolder(Long shareholder_id) {
         interfaceTier.deleteShareHolder(shareholder_id);
    }




    }
