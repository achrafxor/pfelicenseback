package com.etap.production.metier;


import com.etap.production.entity.Produit;
import org.springframework.http.ResponseEntity;

import java.net.URISyntaxException;
import java.util.Collection;

public interface InterfaceProduit {
    public Collection<Produit> getAllProduct();
    public ResponseEntity<?> getProductById(Long id) ;
    public ResponseEntity<?> addProduct(Produit product) throws URISyntaxException;
    public ResponseEntity<?> updateProduct(Produit product,Long product_id);
    public void deleteProduct(Long product_id);
}
