package com.etap.production.metier;

import com.etap.production.dao.UtilisateurRepository;
import com.etap.production.entity.Utilisateur;
import com.etap.production.objects.Authentification;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
@Transactional
public class ImplementationUtilisateur implements InterfaceUtilisateur{
    @Autowired
    private final UtilisateurRepository utilisateurRepository;

    public ImplementationUtilisateur(UtilisateurRepository utilisateurRepository){
        this.utilisateurRepository=utilisateurRepository;
    }
    @Override
    public ResponseEntity<?> addUser(Utilisateur user) throws URISyntaxException {
        Utilisateur userResult=utilisateurRepository.save(user);
        return ResponseEntity.created(new URI("/newUser" + userResult.getId_utilisateur())).body(userResult);

    }

    @Override
    public void deleteUser(Long id_user) {
        utilisateurRepository.deleteById(id_user);
    }

    @Override
    public Collection<Utilisateur> getAllUser() {
        return utilisateurRepository.findAll();
    }

    @Override
    public Collection<Utilisateur> Authentification(Authentification authentification) {
        Collection<Utilisateur> utilisateurs=  utilisateurRepository.findAll().stream().filter(x->x.getMail().equals(authentification.getLogin()) && x.getMdp().equals(authentification.getMdp())).collect(Collectors.toList());
        return utilisateurs;
    }
}
