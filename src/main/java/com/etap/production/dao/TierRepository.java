package com.etap.production.dao;

import com.etap.production.entity.Tier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource

public interface TierRepository extends JpaRepository<Tier,Long> {
}
