package com.custom_shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.custom_shop.model.Customization;

@RepositoryRestResource(path = "customizations")
@CrossOrigin(origins = { "${settings.cors_origin}" })
public interface ICustomization extends JpaRepository<Customization, Long> {
        // @Override
        // default void deleteById(Long id) {
        //         Customization subject = this.findById(id).get();
        //         if (subject != null) {
        //                 subject.setDeleted(true);
        //                 this.save(subject);
        //         } else
        //                 throw new IllegalArgumentException("No se encontró elemento con ID: " + id);
        // }
}
