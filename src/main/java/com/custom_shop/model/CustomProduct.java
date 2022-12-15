package com.custom_shop.model;

import java.util.Set;

import javax.annotation.PostConstruct;
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
    //@JsonBackReference
    //@JoinColumn(name = "seller_id_seller")
    private Seller seller;
    
    @OneToMany(mappedBy = "customProduct")
    private Set<CustomizationApply> customizationsApplied;
    
}
