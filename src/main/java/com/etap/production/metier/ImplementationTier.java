package com.etap.production.metier;

import com.etap.production.dao.LieuRepository;
import com.etap.production.dao.TierRepository;
import com.etap.production.entity.Lieu;
import com.etap.production.entity.Tier;
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
public class ImplementationTier implements InterfaceTier {
    @Autowired
    private final TierRepository tierRepository;
    @Autowired
    private final LieuRepository lieuRepository;
    public ImplementationTier(TierRepository tierRepository,LieuRepository lieuRepository){
        this.tierRepository=tierRepository;
        this.lieuRepository=lieuRepository;
    }

    @Override
    public Collection<Tier> getAllShareHolders() {
        return tierRepository.findAll();
    }

    @Override
    public ResponseEntity<?> getShareHoldersById(Long id) {
        Optional<Tier> shareholder=tierRepository.findById(id);
        return shareholder.map(response -> ResponseEntity.ok().body(response)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @Override
    public ResponseEntity<?> addShareHolder(Tier shareholder,Long lieu_id) throws URISyntaxException {
        Optional<Lieu> resultlieu=lieuRepository.findById(lieu_id);
        if(resultlieu.isEmpty()){
            return null;
        }
        shareholder.setLieu_de_tier(resultlieu.get());
        Tier result=tierRepository.save(shareholder);
        return ResponseEntity.created(new URI("/newShareHolder" + result.getId_tier())).body(result);

    }

    @Override
    public ResponseEntity<?> updateShareHolder(Tier shareholder, Long shareholder_id,Long lieu_id) {
        Optional<Tier> result=tierRepository.findById(shareholder_id);
        if(!result.isEmpty()){
            Optional<Lieu> resultlieu=lieuRepository.findById(lieu_id);
            if(result.isEmpty()){
                return null;
            }else{
                Tier shareholderput=result.get();
                shareholderput.setLieu_de_tier(resultlieu.get());
                shareholderput.setTel(shareholder.getTel());
                shareholderput.setPart(shareholder.getPart());
                shareholderput.setNom_tier(shareholder.getNom_tier());
                tierRepository.save(shareholderput);
                return ResponseEntity.ok().body(tierRepository.save(shareholderput));
            }


        }else{
         return null;
        }
    }

    @Override
    public void deleteShareHolder(Long shareholder_id) {
        tierRepository.deleteById(shareholder_id);
    }
}
