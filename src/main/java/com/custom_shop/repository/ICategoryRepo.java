package com.custom_shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.custom_shop.model.Category;

@RepositoryRestResource(path = "categories")
@CrossOrigin()
public interface ICategoryRepo extends JpaRepository<Category, Long> {
    
}
