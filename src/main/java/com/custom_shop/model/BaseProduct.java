package com.custom_shop.model;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ColumnDefault;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "base_products")
public class BaseProduct {
    // dominio de "los gestores"
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduct;

    @NotNull
    @Column(unique = true)
    private String name;

    private BigDecimal basePrice; // For precision

    private String description;

    private Long delayTimeHours;

    @ColumnDefault("false")
    private boolean deleted = false;

    //@OneToMany
    //(mappedBy = "baseProduct")
    //private Set<PosibleCustomization> posibleCustomizations;

    // @Enumerated(EnumType.STRING)
    // private LogicStatus status;
}