package com.etap.production.api;

import com.etap.production.dao.ConcessionRepository;
import com.etap.production.entity.Concession;
import com.etap.production.metier.ImplementationConcession;
import com.etap.production.metier.InterfaceConcession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/concession")
public class ConcessionApi {

    @Autowired
    private InterfaceConcession interfaceconcession;

    //return all concession
    @GetMapping("/all")
    public Collection<Concession> all(){
        return interfaceconcession.listConcession();
    }
    //return concession by id
    @GetMapping("/getConcessionById/{id}")
    public ResponseEntity<?> getConcessionById(@PathVariable("id") Long id){
        return interfaceconcession.getConcession(id);
    }
    //return list of concession by name
    @GetMapping("/getConcessionByName/{name}")
    public Collection<Concession> getConcessionByName(@PathVariable("name") String name){
        return interfaceconcession.getConcessionByName(name);
    }
    @PostMapping("/newconcession/{id}")
    public void addConcession( @RequestBody Concession concessionparam,@PathVariable("id") Long id) {
       interfaceconcession.addConcession(concessionparam,id);
    }
    @PutMapping("/updateconcession/{id_concession}/{id_lieu}")
    public ResponseEntity<?> updateConcession(@RequestBody Concession concession,@PathVariable("id_concession") Long concession_id,@PathVariable("id_lieu") Long lieu_id){
        return interfaceconcession.updateConcession(concession,concession_id,lieu_id);
    }
    @DeleteMapping("/removeconcession/{id}")
    public void deleteconcession(@PathVariable("id") Long id) {

            interfaceconcession.deleteConcesson(id);
    }




    
}
