package com.custom_shop.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.Getter;
import lombok.Setter;
import lombok.AccessLevel;

@Getter
@Setter
@Entity(name = "custom_products")
@SQLDelete(sql = "UPDATE custom_products SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class CustomProduct extends BaseEntity {

    public CustomProduct() {
        this.customizationsApplied = new HashSet<>();
    }

    @NotNull
    @Size(min = 3, max = 45)
    @Column(unique = true, nullable = false, length = 45)
    private String name;

    @Size(min = 3, max = 512)
    @Column(length = 512)
    private String image = "";

    // @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "base_product_id", referencedColumnName = "id", nullable = false)
    private BaseProduct baseProduct;

    @ManyToOne
    @JoinColumn(name = "sell_point_id", referencedColumnName = "id", nullable = false)
    private SellPoint sellPoint;

    public SellPoint getSellPoint() {
        return sellPoint;
    }

    public void setSellPoint(SellPoint sellPoint) {
        this.sellPoint = sellPoint;
    }

    @OneToMany(mappedBy = "customProduct")
    // @JsonManagedReference
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private Set<CustomizationApply> customizationsApplied;

    public Set<CustomizationApply> getCustomizationsApplied() {
        return new HashSet<>(this.customizationsApplied);
    }

    public void applyCustomization(CustomizationApply customization) {
        this.customizationsApplied.add(customization);
    }

    // public BigDecimal getFinalUnitPrice() {

    // BigDecimal ret = baseProduct.getBasePrice();

    // for (CustomizationApply item : customizationsApplied) {
    // ret = ret.add(item.getCustomization().getAddedPrice());
    // }
    // return ret;
    // };
}
