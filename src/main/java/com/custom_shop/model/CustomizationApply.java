package com.custom_shop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "applied_customizations")
@NoArgsConstructor
@SQLDelete(sql = "UPDATE applied_customizations SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class CustomizationApply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(max = 512)
    @Column(unique = true, nullable = false, length = 512)
    private String value;

    @ColumnDefault("false")
    @NotNull
    private boolean deleted = false;

    @ManyToOne
    @JoinColumn(name = "base_product_id", referencedColumnName = "id", nullable = false)
    private BaseProduct baseProduct;

    @ManyToOne
    @JoinColumn(name = "posibleCustomization_id", referencedColumnName = "id", nullable = false)
    private PosibleCustomization customization;

    // @NotNull
    @ManyToOne
    @JoinColumn(name = "custom_product_id", referencedColumnName = "id", nullable = false)
    // @JsonBackReference
    private CustomProduct customProduct;

}
