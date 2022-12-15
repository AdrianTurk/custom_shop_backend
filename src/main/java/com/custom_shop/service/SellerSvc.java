package com.custom_shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.custom_shop.model.Seller;
import com.custom_shop.repository.ISellerRepo;

@Service
public class SellerSvc {

    @Autowired
    ISellerRepo sellerRepo;

    public List<Seller> list() {
        return sellerRepo.findAll();
    }

    public Seller getById(long id) {
        return sellerRepo.findById(id).get();
    }

    public void delSeller(Long sellerID) {
        //sellerRepo.findById(sellerID).get().setStatus(LogicStatus.DELETED);
    }

    public Seller save(Seller seller) {
        return sellerRepo.save(seller);
    }
}
