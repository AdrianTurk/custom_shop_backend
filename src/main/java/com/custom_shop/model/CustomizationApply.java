package com.custom_shop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ColumnDefault;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "customizations_applied")
@NoArgsConstructor
public class CustomizationApply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String value;

    @ColumnDefault("false")
    @NotNull
    private boolean deleted = false;

    @ManyToOne
    @JoinColumn(name = "base_product_id_product")
    private BaseProduct baseProduct;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "custom_product_id_product")
    // @JsonBackReference
    private CustomProduct customProduct;

    @OneToOne
    private Customization customization;

    // @OneToOne
    // private PosibleCustomization posibleCustomization;

}
