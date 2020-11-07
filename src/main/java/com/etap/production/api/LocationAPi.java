package com.etap.production.api;

import com.etap.production.entity.Lieu;
import com.etap.production.metier.InterfaceLieu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.Collection;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Location")
public class LocationAPi {
    @Autowired
    private InterfaceLieu interfaceLieu;

    @GetMapping("/all")
    public Collection<Lieu> getAllLocation() {
        return interfaceLieu.getAllLocation();
    }
    @GetMapping("/getLocationById/{id}")
    public ResponseEntity<?> getLocationById(@PathVariable("id") Long id) {
        return interfaceLieu.getLocationBYId(id);
    }
    @PostMapping("/addLocation")
    public ResponseEntity<?> addLocation(@RequestBody Lieu location) throws URISyntaxException {
        return interfaceLieu.addLocation(location);
    }
    @PutMapping("/updateLocation/{location_id}")
    public ResponseEntity<?> updateLocation(@RequestBody Lieu location,@PathVariable("location_id") Long location_id){
        return interfaceLieu.updateLocation(location,location_id);
    }
    @DeleteMapping("/deleteLocation/{id}")
    public void deleteLocation(@PathVariable("id") Long location_id){
        interfaceLieu.deleteLocation(location_id);
    }





}
