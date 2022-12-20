package com.custom_shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.custom_shop.repository.ICustomProductRepo;
import com.custom_shop.repository.ISellerRepo;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = { "${settings.cors_origin}" })
public class utilsController {
    @Autowired
    ISellerRepo sellersRepo;

    @Autowired
    ICustomProductRepo costumesRepo;

    // @GetMapping(path = "/products_for_Seller/{id}")
    // public Page<CustomProduct> listSellersProducts(Pageable page, @PathVariable
    // String id) {
    // // long targetId;
    // // if (!utilsController.isNumeric(id)) {
    // // targetId = sellersRepo.findByName(id).get().getIdSeller();
    // // } else {
    // // targetId = Long.parseLong(id);
    // // }
    // // return costumesRepo.findAllBySellerId(page, targetId);
    // // return sellersRepo.findAll(page);
    // return null;
    // }

    // private static boolean isNumeric(String str) {
    // try {
    // Long.parseLong(str);
    // return true;
    // } catch (NumberFormatException ex) {
    // return false;
    // }
    // }
}
