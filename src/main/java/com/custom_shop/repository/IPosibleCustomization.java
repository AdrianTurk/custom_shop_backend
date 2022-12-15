package com.custom_shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.custom_shop.model.PosibleCustomization;

@RepositoryRestResource(path = "posibleCustomizations")
public interface IPosibleCustomization extends JpaRepository<PosibleCustomization, Long>{
    
}
