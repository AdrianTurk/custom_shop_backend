package com.custom_shop.controller;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.custom_shop.DTO.BaseProductDTO;
import com.custom_shop.DTO.PosibleCustomizationDTO;
import com.custom_shop.model.BaseProduct;
import com.custom_shop.model.PosibleCustomization;
import com.custom_shop.repository.IBaseProduct;
import com.custom_shop.repository.ICategoryRepo;
import com.custom_shop.repository.IPossibleCustomization;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RepositoryRestController
@CrossOrigin(origins = { "${settings.cors_origin}" })
public class BaseProductControllerComplement {

    @Autowired
    IBaseProduct baseProductsRepo;

    @Autowired
    ICategoryRepo categoryRepo;


    @Transactional
    @PostMapping("baseProducts")
    public @ResponseBody ResponseEntity<?> addBaseProduct(
            @RequestBody BaseProductDTO data) {

        boolean productExists = baseProductsRepo.existsByNameIgnoreCaseAndDeletedFalse(data.getName());

        if (productExists) {
            log.error("Se intento agregar un elemento ya existente : " + data);
            throw new DataIntegrityViolationException("Se esta intentando dar de alta un elemento duplicado");
        }

        Set<PosibleCustomization> customizations = new HashSet<>();
        for (PosibleCustomizationDTO custDTO : data.getCustomizations()) {
            customizations.add(new PosibleCustomization(custDTO));
        }

        BaseProduct baseItem = new BaseProduct(
                data.getName(), data.getBasePrice(), data.getDescription(),
                data.getDelayTimeHours(), data.getImage(),
                categoryRepo.findById(data.getCategoryId()).get(),
                customizations);

        baseProductsRepo.save(baseItem);

        return new ResponseEntity<>(baseItem, HttpStatus.CREATED);
    }
}
