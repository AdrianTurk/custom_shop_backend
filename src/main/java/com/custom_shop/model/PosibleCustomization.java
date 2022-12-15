package com.custom_shop.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "posible_customizations")
@Getter
@Setter
@NoArgsConstructor
public class PosibleCustomization {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long hours_delay=0;
    
    private BigDecimal addedCost = new BigDecimal("0");
    
    @ManyToOne
    @JoinColumn(name = "base_product_id_product")
    @JsonBackReference
    private BaseProduct baseProduct;
    
    @ManyToOne
    @JsonBackReference
    private Customization customization;
}
