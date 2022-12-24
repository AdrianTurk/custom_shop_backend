package com.custom_shop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "cart_items")
@NoArgsConstructor
@SQLDelete(sql = "UPDATE cart_items SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Min(value = 1)
    private long quantity;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
    private CustomProduct product;

    @NotNull
    @ColumnDefault("false")
    @Column(nullable = false)
    private boolean deleted = false;

    @ManyToOne
    @JoinColumn(name = "cart_id", referencedColumnName = "id", nullable = false)
    private Cart cart;

    // public BigDecimal getFinalUnitPrice() {

    // BigDecimal ret = product.getBaseProduct().getBasePrice();
    // // TODO: Repair:
    // // for (CustomizationApply item : product.getCustomizationsApplied()) {
    // // ret = ret.add(item.getCustomization().getAddedPrice());
    // // }
    // return ret;
    // };
}
