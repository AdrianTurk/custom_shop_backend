package com.custom_shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.custom_shop.model.Seller;

@Repository
public interface ISellerRepo extends JpaRepository<Seller, Long> {

}
