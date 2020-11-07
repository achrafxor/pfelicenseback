package com.etap.production.dao;

import com.etap.production.entity.Puit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource

public interface PuitRepository extends JpaRepository<Puit,Long> {
}
