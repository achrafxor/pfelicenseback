package com.etap.production.metier;

import com.etap.production.entity.Lieu;

import org.springframework.http.ResponseEntity;

import java.net.URISyntaxException;
import java.util.Collection;

public interface InterfaceLieu {
    public Collection<Lieu> getAllLocation();
    public ResponseEntity<?> getLocationBYId(Long id) ;
    public ResponseEntity<?> addLocation(Lieu location) throws URISyntaxException;
    public ResponseEntity<?> updateLocation(Lieu location,Long location_id);
    public void deleteLocation(Long location_id);
}
