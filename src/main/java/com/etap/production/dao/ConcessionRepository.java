package com.etap.production.dao;

import com.etap.production.entity.Concession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource

public interface ConcessionRepository extends JpaRepository<Concession,Long> {
}
