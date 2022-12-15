package com.custom_shop.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "cart_items")
@NoArgsConstructor
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cartItemId;
    
    @NotNull
    @OneToOne
    private CustomProduct product;
    
    @NotNull
    @Min(value=1)
    private long quantity;

    // @ManyToOne
    // private Cart cart;

    public BigDecimal getFinalUnitPrice() {
        BigDecimal ret;
        ret = product.getBaseProduct().getBasePrice();
         product.getCustomizationsApplied().forEach(cust -> {
             ret.add(cust.getPosibleCustomization().getAddedCost());
         });
        return ret;
    };
}
