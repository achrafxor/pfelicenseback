package com.etap.production.metier;

import com.etap.production.entity.Lieu;
import com.etap.production.entity.Tier;
import org.springframework.http.ResponseEntity;

import java.net.URISyntaxException;
import java.util.Collection;

public interface InterfaceTier {
    public Collection<Tier> getAllShareHolders();
    public ResponseEntity<?> getShareHoldersById(Long id) ;
    public ResponseEntity<?> addShareHolder(Tier shareholder,Long lieu_id) throws URISyntaxException;
    public ResponseEntity<?> updateShareHolder(Tier shareholder,Long shareholder_id,Long lieu_id);
    public void deleteShareHolder(Long shareholder_id);
}
