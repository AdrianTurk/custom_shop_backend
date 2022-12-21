package com.custom_shop.controller;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import com.custom_shop.model.Seller;
import com.custom_shop.repository.ICategoryRepo;
import com.custom_shop.repository.ICustomization;
import com.custom_shop.repository.ISellerRepo;

@RepositoryRestController
@CrossOrigin(origins = { "${settings.cors_origin}" })
public class SellerControllerComplement {

    @Autowired
    ISellerRepo sellersRepo;

    @Autowired
    ICustomization customizationRepo;

    @Autowired
    ICategoryRepo categoryRepo;

    
    @Transactional
    @DeleteMapping("sellers/{id}")
    public @ResponseBody ResponseEntity<?> logicDelete(@PathVariable("id") long id) {
        Optional<Seller> item = sellersRepo.findById(id);
        if (item.isEmpty() || item.get().isDeleted())
            return ResponseEntity.notFound().build();

        item.get().setDeleted(true);

        return ResponseEntity.noContent().build();
    }
}
