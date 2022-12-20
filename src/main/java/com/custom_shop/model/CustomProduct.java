package com.custom_shop.model;

import java.math.BigDecimal;
import java.util.Set;

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
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "custom_products")
@NoArgsConstructor
public class CustomProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCustomProduct;

    @NotNull
    @Column(unique = true)
    private String name;

    // @Enumerated(EnumType.STRING)
    // private LogicStatus status;
    
    @JsonBackReference
    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    @ColumnDefault("false")
    private boolean deleted = false;
   
    @ManyToOne
    //(mappedBy = "baseProduct")
    private BaseProduct baseProduct;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;


    private String imageSampleUrl="";
    
    @OneToMany(mappedBy = "customProduct")
    //@JsonManagedReference
    private Set<CustomizationApply> customizationsApplied;

    public BigDecimal getFinalUnitPrice() {

        BigDecimal ret = baseProduct.getBasePrice();

        for (CustomizationApply item : customizationsApplied) {
            ret = ret.add(item.getCustomization().getAddedPrice());
        }
        return ret;
    };
    
}
