package com.custom_shop.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ColumnDefault;

import lombok.Getter;
import lombok.Setter;
import lombok.AccessLevel;

@Getter
@Setter
@Entity(name = "base_products")
public class BaseProduct {
    // dominio de "los gestores"
    public BaseProduct() {
        this.posibleCustomizations = new ArrayList<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique = true)
    private String name;

    private BigDecimal basePrice; // For precision

    private String description;

    private Long delayTimeHours;

    @ColumnDefault("false")
    @NotNull
    private boolean deleted = false;

    @ManyToMany
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private List<Customization> posibleCustomizations;


    public List<Customization> getPosibleCustomizations() {
        return new ArrayList<>(posibleCustomizations);
    }

    public void addPosibleCustomization(Customization item) {
        this.posibleCustomizations.add(item);
    }

}