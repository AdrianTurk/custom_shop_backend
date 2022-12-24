package com.custom_shop.model;

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
import javax.validation.constraints.Size;

import org.hibernate.annotations.ColumnDefault;
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
public class CustomProduct {

    public CustomProduct() {
        this.customizationsApplied = new ArrayList<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(min = 3, max = 45)
    @Column(unique = true, nullable = false, length = 45)
    private String name;

    @Size(min = 3, max = 512)
    @Column(length = 512)
    private String image = "";

    @ColumnDefault("false")
    private boolean deleted = false;

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
    private List<CustomizationApply> customizationsApplied;

    public List<CustomizationApply> getCustomizationsApplied() {
        return new ArrayList<>(this.customizationsApplied);
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
