package com.etap.production.metier;

import com.etap.production.entity.Puit;
import com.etap.production.entity.Utilisateur;
import com.etap.production.objects.Authentification;
import org.springframework.http.ResponseEntity;

import java.net.URISyntaxException;
import java.util.Collection;

public interface InterfaceUtilisateur {
    public ResponseEntity<?> addUser(Utilisateur user) throws URISyntaxException;
    public void deleteUser(Long delete);
    public Collection<Utilisateur> getAllUser();
    public Collection<Utilisateur> Authentification(Authentification authentification);




}
