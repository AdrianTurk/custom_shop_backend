package com.custom_shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.custom_shop.model.Seller;

@Repository
public interface ISellerRepo extends JpaRepository<Seller, Long> {
        // For MGR

        // public Collection<Seller> listAll();

        // public Optional<Seller> findById(long id);

        // public Optional<Seller> findByName(String name);
        // @Override
        // default void deleteById(Long id) {
        //         Seller subject = this.findById(id).get();
        //         if (subject != null) {
        //                 subject.setDeleted(true);
        //                 this.save(subject);
        //         } else
        //                 throw new IllegalArgumentException("No se encontró elemento con ID: " + id);
        // }
}
