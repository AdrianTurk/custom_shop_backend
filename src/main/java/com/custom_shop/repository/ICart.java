package com.custom_shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.custom_shop.model.Cart;

@RepositoryRestResource(path = "carts")
public interface ICart extends JpaRepository<Cart, Long>{
    
}
