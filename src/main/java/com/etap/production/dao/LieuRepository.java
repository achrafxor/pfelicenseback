package com.etap.production.dao;

import com.etap.production.entity.Lieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource

public interface LieuRepository extends JpaRepository<Lieu,Long> {
}
