package com.etap.production.metier;

import com.etap.production.dao.ConcessionRepository;
import com.etap.production.dao.PuitRepository;
import com.etap.production.entity.Concession;
import com.etap.production.entity.LigneProduction;
import com.etap.production.entity.Puit;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.ObjectProvider;
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
public class ImplementationPuit implements InterfacePuit {
    @Autowired
    private final PuitRepository wellrepository;
    @Autowired
    private final ConcessionRepository concessionrepository;

    public ImplementationPuit(PuitRepository wellrepository,ConcessionRepository concessionrepository){
        this.wellrepository=wellrepository;
        this.concessionrepository=concessionrepository;
    }
    @Override
    public Collection<Puit> getAllwell() {
        return wellrepository.findAll();
    }

    @Override
    public ResponseEntity<?> getWellById(Long id) {
        Optional<Puit> well=wellrepository.findById(id);
        return well.map(response -> ResponseEntity.ok().body(response)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));    }

    @Override
    public ResponseEntity<?> addWell(Puit well, Long concession_id) throws URISyntaxException {
        Optional<Concession> resultconcession=concessionrepository.findById(concession_id);
        if(resultconcession.isEmpty()){
            return null;
        }
        well.setConcession_de_puit(resultconcession.get());
        Puit result=wellrepository.save(well);
        return ResponseEntity.created(new URI("/newWell" + result.getId_puit())).body(result);

    }

    @Override
    public ResponseEntity<?> updateWell(Puit well, Long well_id, Long concession_id) {
        Optional<Puit> wellresult=wellrepository.findById(well_id);
        //if the well exist make the treatment
        if(!wellresult.isEmpty()){
           //bring the object Concession with the id concession_id
            Optional<Concession> resultconcession=concessionrepository.findById(concession_id);
            //if there is no object concession with this id return null
            if(resultconcession.isEmpty()){
                return null;
            }else{
                //all is right make the update operation
                Puit wellput=wellresult.get();
                wellput.setConcession_de_puit(resultconcession.get());
                wellput.setNom_puit(well.getNom_puit());
                wellrepository.save(wellput);
                return ResponseEntity.ok().body(wellrepository.save(wellput));

            }


        }
         else{
            //else return null we didnt find any well with this id to update
            return null;
        }
    }

    @Override
    public void deleteWell(Long id) {
        wellrepository.deleteById(id);
    }


}
