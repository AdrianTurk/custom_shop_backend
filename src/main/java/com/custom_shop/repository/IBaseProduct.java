package com.custom_shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.custom_shop.model.BaseProduct;

@RepositoryRestResource(path = "base_products")
public interface IBaseProduct extends JpaRepository<BaseProduct, Long> {
        @Override
        default void deleteById(Long id) {
                BaseProduct subject = this.findById(id).get();
                if (subject != null) {
                        subject.setDeleted(true);
                        this.save(subject);
                } else
                        throw new IllegalArgumentException("No se encontró elemento con ID: " + id);
        }
}