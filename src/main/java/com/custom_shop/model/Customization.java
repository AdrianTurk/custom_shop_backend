package com.custom_shop.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ColumnDefault;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "customizations")
@NoArgsConstructor
public class Customization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCustomization;

    @NotNull
    // @Column(unique=true)
    private String name;
    private String description;
    
    @ColumnDefault("0")
    private BigDecimal addedPrice;
    
    @ColumnDefault("0")
    private long hoursDelay=0;

    @ColumnDefault("false")
    private boolean deleted = false;
}
