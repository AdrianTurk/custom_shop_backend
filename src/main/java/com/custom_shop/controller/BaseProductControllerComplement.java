package com.custom_shop.controller;

import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.custom_shop.model.BaseProduct;
import com.custom_shop.model.Customization;
import com.custom_shop.repository.IBaseProduct;

@RepositoryRestController
@CrossOrigin(origins = { "${settings.cors_origin}" })
public class BaseProductControllerComplement {
    @Autowired
    IBaseProduct baseProductsRepo;

    @Transactional
    @DeleteMapping("baseProducts/{id}")
    public @ResponseBody ResponseEntity<?> logicDelete(@PathVariable("id") long id) {
        Optional<BaseProduct> item = baseProductsRepo.findById(id);
        if (item.isEmpty() || item.get().isDeleted())
            return ResponseEntity.notFound().build();

        item.get().setDeleted(true);

        return ResponseEntity.noContent().build();
    }

    @Transactional
    @PostMapping("baseProducts/{id}/posibleCustomizations")
    public @ResponseBody ResponseEntity<?> addCustomization(@PathVariable("id") long id, @RequestBody Customization customization){
        Optional<BaseProduct> item = baseProductsRepo.findById(id);
        if (item.isEmpty() || item.get().isDeleted())
            return ResponseEntity.notFound().build();

        item.get().addPosibleCustomization(customization);

        return ResponseEntity.noContent().build();
    }
}
