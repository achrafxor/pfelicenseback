package com.etap.production.metier;

import com.etap.production.dao.ConcessionRepository;
import com.etap.production.dao.PartRepository;
import com.etap.production.dao.TierRepository;
import com.etap.production.entity.*;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional

public class ImplementationPart implements InterfacePart {
    @Autowired
    private PartRepository partRepository;
    @Autowired
    private ConcessionRepository concessionRepository;
    @Autowired
    private TierRepository tierRepository;
    public  ImplementationPart(PartRepository partRepository,ConcessionRepository concessionRepository
    ,TierRepository tierRepository){
     this.tierRepository=tierRepository;
     this.concessionRepository=concessionRepository;
     this.partRepository=partRepository;
    }


    @Override
    public Collection<Part> getAllPart() {
        return partRepository.findAll();
    }

    @Override
    public Part getPartBYId(Long id_Concession, Long id_tiers) {

    Part part= partRepository.getOne(new PartPk(id_Concession,id_tiers));
    return part;

    }

    @Override
    public void addPart(Part part , Long id_Concession, Long id_tiers) throws URISyntaxException {
        Optional<Concession> concessions=concessionRepository.findById(id_Concession);
        Optional<Tier> tiers=tierRepository.findById(id_tiers);

        part.setConcession(concessions.get());
        part.setTier(tiers.get());
        partRepository.save(part);
    }

    @Override
    public ResponseEntity<?> updatePart(Lieu location, Long location_id) {
        return null;
    }

    @Override
    public void deleteLocation(Long location_id) {
    }
}
