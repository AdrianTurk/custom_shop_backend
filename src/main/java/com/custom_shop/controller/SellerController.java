package com.custom_shop.controller;

import java.lang.instrument.IllegalClassFormatException;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.custom_shop.model.Seller;
import com.custom_shop.repository.ISellerRepo;

@RestController
@RequestMapping("/api/sellers")
@CrossOrigin(origins = { "${settings.cors_origin}" })
public class SellerController {

    @Autowired
    ISellerRepo sellersRepo;

    @GetMapping(path = { "", "/" })
    public Page<Seller> listSellers(Pageable page) {
        return sellersRepo.findAll(page);
    }

    @GetMapping(path = "/{sellerID}")
    public Seller getSeller(@PathVariable("sellerID") Long sellerID) {
        return sellersRepo.findById(sellerID).get();
    }

    @PostMapping(path = { "", "/" })
    // responseEntity?
    public Seller addSeller(@RequestBody @Valid Seller seller, BindingResult bindingResult)
            throws IllegalClassFormatException {
        if (bindingResult.hasErrors())
            throw new IllegalClassFormatException("Objeto vendedor mal formado.");
        return sellersRepo.save(seller);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public @ResponseBody ResponseEntity<?> logicDelete(@PathVariable("id") long id) {
        Optional<Seller> item = sellersRepo.findById(id);
        if (item.isEmpty() || item.get().isDeleted())
            return ResponseEntity.notFound().build();

        item.get().setDeleted(true);

        return ResponseEntity.noContent().build();
    }

    // @PatchMapping(path = "/{id}", consumes = "application/json-patch+json")
    // public ResponseEntity<Customer> updateCustomer(@PathVariable String id,
    // @RequestBody JsonPatch patch) {
    // try {
    // Customer customer =
    // customerService.findCustomer(id).orElseThrow(CustomerNotFoundException::new);
    // Customer customerPatched = applyPatchToCustomer(patch, customer);
    // customerService.updateCustomer(customerPatched);
    // return ResponseEntity.ok(customerPatched);
    // } catch (JsonPatchException | JsonProcessingException e) {
    // return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    // } catch (CustomerNotFoundException e) {
    // return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    // }
    // }

    @PatchMapping(path = "/{sellerID}")
    public void patchSeller(@PathVariable("sellerID") Long sellerID, @RequestBody Seller seller) {
        Seller foundSeller;
        if ((foundSeller = sellersRepo.findById(sellerID).get()) != null) {
            foundSeller.patch(seller);
            sellersRepo.save(foundSeller);
        }

    }
}