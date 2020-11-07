package com.etap.production.metier;

import com.etap.production.dao.ConcessionRepository;
import com.etap.production.dao.LigneProductionRepository;
import com.etap.production.dao.ProduitRepository;
import com.etap.production.dao.PuitRepository;
import com.etap.production.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.CollationElementIterator;
import java.util.Collection;
import java.util.Optional;

@Service
@Transactional
public class ImplementationLigneProduction implements InterfaceLigneProduction {
    @Autowired
    private final LigneProductionRepository ligneproductionrepository;
    @Autowired
    private final ProduitRepository produitrepository;
    @Autowired
    private final ConcessionRepository concessionrepository;
    @Autowired
    private final PuitRepository puitrepository;

    public ImplementationLigneProduction(LigneProductionRepository ligneproductionrepository,ProduitRepository produitrepository,ConcessionRepository concessionrepository,PuitRepository puitrepository){
        this.ligneproductionrepository=ligneproductionrepository;
        this.produitrepository=produitrepository;
        this.concessionrepository=concessionrepository;
        this.puitrepository=puitrepository;
    }

    @Override
    public Collection<LigneProduction> getALLProductionLine() {
        return ligneproductionrepository.findAll();

    }

    @Override
    public ResponseEntity<?> getProductionLineById(Long id) {
        Optional<LigneProduction> ligneProduction=ligneproductionrepository.findById(id);
        return ligneProduction.map(response -> ResponseEntity.ok().body(response)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @Override
    public ResponseEntity<?> addProductionLine(LigneProduction ligneproduction, Long concession_id, Long product_id, Long well_id) throws URISyntaxException {
        Optional<Concession> resultconcession=concessionrepository.findById(concession_id);
        Optional<Produit>       resultproduct=produitrepository.findById(product_id);
        Optional<Puit>             resultwell=puitrepository.findById(well_id);
        if(resultconcession.isEmpty() || resultproduct.isEmpty()||resultwell.isEmpty())
        {
            return null;
        }
        ligneproduction.setConcession_ligne_production(resultconcession.get());
        ligneproduction.setProduit_ligne_production(resultproduct.get());
        ligneproduction.setPuit_ligne_production(resultwell.get());
        LigneProduction result=ligneproductionrepository.save(ligneproduction);
        return ResponseEntity.created(new URI("/newProductionLine" + result.getId_ligne())).body(result);


    }

    @Override
    public ResponseEntity<?> updateProductionLine(LigneProduction ligneproduction,Long production_id, Long concession_id, Long product_id, Long well_id) {


        Optional<LigneProduction> productionresult = ligneproductionrepository.findById(production_id);

        if(!productionresult.isEmpty()){
            //if foreign key id dosent exist

            Optional<Concession> resultconcession=concessionrepository.findById(concession_id);
            Optional<Produit>    resultproduit   =produitrepository.findById(product_id);
            Optional<Puit>       resultpuit      =puitrepository.findById(well_id);

            if(resultconcession.isEmpty()||resultproduit.isEmpty()||resultpuit.isEmpty()){
                return null;
            }else{

                LigneProduction productionput    =productionresult.get();
                productionput.setQte(ligneproduction.getQte());
                productionput.setCout(ligneproduction.getCout());
                productionput.setDate(ligneproduction.getDate());
                productionput.setProduit_ligne_production(resultproduit.get());
                productionput.setConcession_ligne_production(resultconcession.get());
                productionput.setPuit_ligne_production(resultpuit.get());
                LigneProduction result=ligneproductionrepository.save(productionput);
                return ResponseEntity.ok().body(result);
            }
        }else{
            return null;
        }




    }

    @Override
    public void deleteProductionLine(Long id) {
        ligneproductionrepository.deleteById(id);

    }
}
