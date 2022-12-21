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

import com.custom_shop.model.Cart;
import com.custom_shop.repository.ICart;

@RepositoryRestController
@CrossOrigin(origins = { "${settings.cors_origin}" })
public class CartControllerComplement {
    @Autowired
    ICart cartRepo;

    @Transactional
    @DeleteMapping("carts/{id}")
    public @ResponseBody ResponseEntity<?> logicDelete(@PathVariable("id") long id) {
        Optional<Cart> item = cartRepo.findById(id);
        if (item.isEmpty() || item.get().isDeleted())
            return ResponseEntity.notFound().build();

        item.get().setDeleted(true);

        return ResponseEntity.noContent().build();
    }
}
