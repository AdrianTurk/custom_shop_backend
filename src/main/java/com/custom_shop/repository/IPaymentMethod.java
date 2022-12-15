package com.custom_shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.custom_shop.model.PaymentMethod;

@RepositoryRestResource(path = "payment_methods")
public interface IPaymentMethod extends JpaRepository<PaymentMethod, Long> {
    @Override
    default void deleteById(Long id) {
            PaymentMethod subject = this.findById(id).get();
            if (subject != null) {
                    subject.setDeleted(true);
                    this.save(subject);
            } else
                    throw new IllegalArgumentException("No se encontró elemento con ID: " + id);
    }
}