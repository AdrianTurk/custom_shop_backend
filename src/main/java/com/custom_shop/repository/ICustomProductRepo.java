package com.custom_shop.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.custom_shop.model.CustomProduct;

@RepositoryRestResource(path = "customProducts")
@CrossOrigin(origins = { "${settings.cors_origin}" })
public interface ICustomProductRepo extends JpaRepository<CustomProduct, Long> {
        // For MGR

        // public Collection<Seller> listAll();

        // public Optional<Seller> findById(long id);

        // public Optional<Seller> findByName(String name);
        // @Override
        // default void deleteById(Long id) {
        //         CustomProduct subject = this.findById(id).get();
        //         if (subject != null) {
        //                 subject.setDeleted(true);
        //                 this.save(subject);
        //         } else
        //                 throw new IllegalArgumentException("No se encontró elemento con ID: " + id);
        // }

}
