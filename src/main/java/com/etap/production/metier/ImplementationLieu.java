package com.etap.production.metier;

import com.etap.production.dao.LieuRepository;
import com.etap.production.entity.Lieu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

@Service
@Transactional
public class ImplementationLieu implements InterfaceLieu {
    @Autowired
    private final LieuRepository lieuRepository;
    public ImplementationLieu(LieuRepository lieuRepository){
        this.lieuRepository=lieuRepository;
    }

    @Override
    public Collection<Lieu> getAllLocation() {
        return lieuRepository.findAll();
    }

    @Override
    public ResponseEntity<?> getLocationBYId(Long id) {
        Optional<Lieu> location=lieuRepository.findById(id);
        return location.map(response -> ResponseEntity.ok().body(response)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));


    }

    @Override
    public ResponseEntity<?> addLocation(Lieu location) throws URISyntaxException {
        Lieu result =lieuRepository.save(location);
        return ResponseEntity.created(new URI("/newProduct" + result.getId_lieu())).body(result);

    }

    @Override
    public ResponseEntity<?> updateLocation(Lieu location, Long location_id) {
        Optional<Lieu> result=lieuRepository.findById(location_id);
        if(!result.isEmpty()){
            Lieu locationput=result.get();
            locationput.setConcessionCollection(location.getConcessionCollection());
            locationput.setPays(location.getPays());
            locationput.setRegion(location.getRegion());
            locationput.setZip_code(location.getZip_code());
            lieuRepository.save(locationput);
            return ResponseEntity.ok().body(lieuRepository.save(locationput));

        }else{
            return null;
        }
    }

    @Override
    public void deleteLocation(Long location_id) {
        lieuRepository.deleteById(location_id);
    }
}
