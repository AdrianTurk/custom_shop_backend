package com.custom_shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.custom_shop.model.PaymentMethod;

@RepositoryRestResource(path = "paymentMethods")
@CrossOrigin(origins = { "${settings.cors_origin}" })
public interface IPaymentMethod extends JpaRepository<PaymentMethod, Long> {

}