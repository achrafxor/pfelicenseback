package com.etap.production.dao;

import com.etap.production.entity.LigneProduction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource

public interface LigneProductionRepository extends JpaRepository<LigneProduction,Long> {

}
