package com.etap.production.metier;

import com.etap.production.dao.ConcessionRepository;
import com.etap.production.dao.LieuRepository;
import com.etap.production.entity.Concession;
import com.etap.production.entity.Lieu;
import javassist.NotFoundException;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class ImplementationConcession implements InterfaceConcession {
    @Autowired
    private final ConcessionRepository concessionrepository;

    @Autowired
    private final LieuRepository lieurepository;


    public ImplementationConcession(ConcessionRepository concessionrepository,LieuRepository lieuRepository) {
        this.concessionrepository = concessionrepository;
        this.lieurepository=lieuRepository;
    }


    @Override
    public ResponseEntity<?> getConcession(Long concession_id)  {
        Optional<Concession> c=concessionrepository.findById(concession_id);
        return c.map(response -> ResponseEntity.ok().body(response)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public Collection<Concession> getConcessionByName(String name) {
        Collection<Concession> ConcessionName=concessionrepository.findAll().stream().
                filter(x->x.getNom_concession().equals(name)).collect(Collectors.toList());
        return  ConcessionName;
        
    }




    @Override
    public void addConcession(Concession concessionparam,Long idLieu) {



        Optional<Lieu> resultlieu=lieurepository.findById(idLieu);
        concessionparam.setLieu_de_concession(resultlieu.get());
        Concession result=concessionrepository.save(concessionparam);

    }

    @Override
    public ResponseEntity<?> updateConcession(Concession concession, Long concession_id, Long location_id) {
        //find the concession with the passed id
        Optional<Concession> concessionresult=concessionrepository.findById(concession_id);
        //if object exist make the treatment
        if(!concessionresult.isEmpty()){
            //bring the object lieu with the passed id
            Optional<Lieu> resultlieu=lieurepository.findById(location_id);
            if(resultlieu.isEmpty()){
                return null;
            }else{
                Concession concessionput=concessionresult.get();
                concessionput.setLieu_de_concession(resultlieu.get());
                concessionput.setPart(concession.getPart());
                concessionput.setListe_puit_du_concession(concession.getListe_puit_du_concession());
                concessionput.setDate_ouverture(concession.getDate_ouverture());
                concessionput.setDate_cloture(concession.getDate_cloture());
                concessionput.setNom_concession(concession.getNom_concession());
                concessionput.setCollection_concession(concession.getCollection_concession());
                concessionrepository.save(concessionput);
                return ResponseEntity.ok().body(concessionrepository.save(concessionput));

            }



        }else{
            return null;
        }
    }


    @Override
    public void deleteConcesson(Long concession_id)  {
        concessionrepository.deleteById(concession_id);
    }

    @Override
    public Collection<Concession> listConcession() {
        return concessionrepository.findAll();
    }
}
