package com.etap.production.api;

import com.etap.production.entity.Puit;
import com.etap.production.entity.Utilisateur;
import com.etap.production.metier.InterfaceUtilisateur;
import com.etap.production.objects.Authentification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.Collection;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserAPi {
    @Autowired
    private InterfaceUtilisateur interfaceUtilisateur;
    @GetMapping("/all")
    public Collection<Utilisateur> getAllUsers() {
        return interfaceUtilisateur.getAllUser();

    }

    @PostMapping("/add")
    public ResponseEntity<?> addUser(@RequestBody  Utilisateur user) throws URISyntaxException {
        return interfaceUtilisateur.addUser(user);
    }
    @GetMapping("/Login")
    public Collection<Utilisateur> Login(@RequestBody Authentification authentification){
        return interfaceUtilisateur.Authentification(authentification);
    }

}
