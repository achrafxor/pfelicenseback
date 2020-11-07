package com.etap.production.api;

import com.etap.production.entity.Produit;
import com.etap.production.metier.InterfaceProduit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.Collection;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/product")
public class ProductApi {
    @Autowired
    private InterfaceProduit interfaceproduct;

    @GetMapping("/getAll")
    Collection<Produit> getAllProduct(){
       return interfaceproduct.getAllProduct();
    }
    @GetMapping("/getProductById/{id}")
    public ResponseEntity<?> getProductById(@PathVariable("id") Long id){
        return interfaceproduct.getProductById(id);
    }
    @PutMapping("/updateProduct/{Product_id}")
    public ResponseEntity<?> updateProduct(@RequestBody Produit product,@PathVariable("Product_id") Long product_id) {
        return interfaceproduct.updateProduct(product,product_id);
    }
    @PostMapping("/addProduct")
    public ResponseEntity<?> addProduct(@RequestBody Produit product) throws URISyntaxException {
        return interfaceproduct.addProduct(product);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable("id") Long id){
        interfaceproduct.deleteProduct(id);
    }









    }
