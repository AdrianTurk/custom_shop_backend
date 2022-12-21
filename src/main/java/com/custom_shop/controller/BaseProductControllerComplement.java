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
import com.custom_shop.model.BaseProduct;

import com.custom_shop.repository.IBaseProduct;
import com.custom_shop.repository.ICategoryRepo;
import com.custom_shop.repository.ICustomization;

@RepositoryRestController
@CrossOrigin(origins = { "${settings.cors_origin}" })
public class BaseProductControllerComplement {

    @Autowired
    IBaseProduct baseProductsRepo;

    @Autowired
    ICustomization customizationRepo;

    @Autowired
    ICategoryRepo categoryRepo;

    @Transactional
    @DeleteMapping("baseProducts/{id}")
    public @ResponseBody ResponseEntity<?> logicDelete(@PathVariable("id") long id) {
        Optional<BaseProduct> item = baseProductsRepo.findById(id);
        if (item.isEmpty() || item.get().isDeleted())
            return ResponseEntity.notFound().build();

        item.get().setDeleted(true);

        return ResponseEntity.noContent().build();
    }

    // @Transactional
    // @PostMapping("baseProducts/{id}/posibleCustomizations")
    // public @ResponseBody ResponseEntity<?> addCustomization(@PathVariable("id")
    // long id,
    // @RequestBody Customization customization) {

    // Optional<BaseProduct> product = baseProductsRepo.findById(id);
    // Optional<Customization> cust =
    // customizationRepo.findById(customization.getId());

    // if (product.isEmpty() || product.get().isDeleted() || cust.isEmpty() ||
    // cust.get().isDeleted())
    // return ResponseEntity.notFound().build();

    // product.get().addPosibleCustomization(cust.get());

    // return ResponseEntity.noContent().build();
    // }

    // @Transactional
    // @PostMapping("baseProducts/{id}/category")
    // public @ResponseBody ResponseEntity<?> addCategory(@PathVariable("id") long
    // prodId,
    // @RequestBody long categoryId) {

    // Optional<BaseProduct> product = baseProductsRepo.findById(prodId);
    // Optional<Category> cat = categoryRepo.findById(categoryId);

    // if (product.isEmpty() || product.get().isDeleted() || cat.isEmpty() ||
    // cat.get().isDeleted())
    // return ResponseEntity.notFound().build();

    // product.get().setCategory(cat.get());

    // return new ResponseEntity<>(cat.get(), HttpStatus.CREATED);
    // }

}
