package com.custom_shop.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ColumnDefault;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;
import lombok.AccessLevel;

@Getter
@Setter
@Entity(name = "custom_products")
public class CustomProduct {
    public CustomProduct() {
        this.customizationsApplied = new ArrayList<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(unique = true)
    private String name;

    @JsonBackReference
    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    @ColumnDefault("false")
    @NotNull
    private boolean deleted = false;

    @ManyToOne
    // (mappedBy = "baseProduct")
    private BaseProduct baseProduct;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;

    private String imageSampleURL = "";

    @OneToMany
    // (mappedBy = "customProduct")
    // @JsonManagedReference
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private List<CustomizationApply> customizationsApplied;

    public List<CustomizationApply> getCustomizationsApplied() {
        return new ArrayList<>(this.customizationsApplied);
    }

    public void applyCustomization(CustomizationApply customization) {
        this.customizationsApplied.add(customization);
    }

    public BigDecimal getFinalUnitPrice() {

        BigDecimal ret = baseProduct.getBasePrice();

        for (CustomizationApply item : customizationsApplied) {
            ret = ret.add(item.getCustomization().getAddedPrice());
        }
        return ret;
    };
}
