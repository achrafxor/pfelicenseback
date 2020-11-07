package com.etap.production.api;

import com.etap.production.entity.Part;
import com.etap.production.metier.InterfacePart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.Collection;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Part")
public class PartApi {
    @Autowired
    private InterfacePart interfacePart;

    @GetMapping("/all")
    public Collection<Part> getAllPart() {
        return interfacePart.getAllPart();
    }

    @PostMapping("/addpart/{concession_id}/{tier_id}")
    public void addPart(@RequestBody  Part part,@PathVariable("concession_id") Long id_Concession,@PathVariable("tier_id") Long id_tiers) throws URISyntaxException {
        interfacePart.addPart(part, id_Concession, id_tiers);
    }
}