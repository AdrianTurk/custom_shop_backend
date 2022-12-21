package com.custom_shop.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ColumnDefault;

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
    private long id;

    @NotNull
    @OneToOne
    private CustomProduct product;

    @NotNull
    @Min(value = 1)
    private long quantity;

    @ColumnDefault("false")
    @NotNull
    private boolean deleted = false;

    public BigDecimal getFinalUnitPrice() {

        BigDecimal ret = product.getBaseProduct().getBasePrice();
        // TODO: Repair:
        // for (CustomizationApply item : product.getCustomizationsApplied()) {
        // ret = ret.add(item.getCustomization().getAddedPrice());
        // }
        return ret;
    };
}
