package com.etap.production.metier;

import com.etap.production.dao.ProduitRepository;
import com.etap.production.entity.Produit;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.plaf.PanelUI;
import javax.transaction.Transactional;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

@Service
@Transactional
public class ImplementationProduit implements InterfaceProduit {
    @Autowired
    private final ProduitRepository productrepository;
    public ImplementationProduit(ProduitRepository productrepository){
        this.productrepository=productrepository;
    }
    @Override
    public Collection<Produit> getAllProduct() {
        return productrepository.findAll();
    }

    @Override
    public ResponseEntity<?> getProductById(Long id) {
        Optional<Produit> product=productrepository.findById(id);
        return product.map(response -> ResponseEntity.ok().body(response)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

}

    @Override
    public ResponseEntity<?> addProduct(Produit product) throws URISyntaxException {
        Produit result=productrepository.save(product);
        return ResponseEntity.created(new URI("/newProduct" + result.getId_produit())).body(result);

    }

    @Override
    public ResponseEntity<?> updateProduct(Produit product, Long product_id) {
        Optional<Produit> productresult=productrepository.findById(product_id);
        //if product with this id do the treatment
        if(!productresult.isEmpty()) {
            Produit productput=productresult.get();
            productput.setQte(product.getQte());
            productput.setQualite(product.getQualite());
            productput.setType(product.getType());
            productput.setCollection_produit(product.getCollection_produit());
            productput.setReserve(product.getReserve());
            productrepository.save(productput);
            return ResponseEntity.ok().body(productrepository.save(productput));
        }else {
            //else return null
            return null;
        }

    }

    @Override
    public void deleteProduct(Long product_id) {
        productrepository.deleteById(product_id);
    }
}

