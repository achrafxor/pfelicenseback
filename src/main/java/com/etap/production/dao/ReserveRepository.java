package com.etap.production.dao;

import com.etap.production.entity.Reserve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ReserveRepository extends JpaRepository<Reserve,Long> {
}
