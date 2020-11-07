package com.etap.production.dao;

import com.etap.production.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource

public interface ProduitRepository extends JpaRepository<Produit,Long> {
}
