package com.custom_shop.model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
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
@Entity(name = "base_products")
@SQLDelete(sql = "UPDATE base_products SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class BaseProduct {

    public BaseProduct() {
        this.posibleCustomizations = new HashSet<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 10, max = 45)
    @Column(unique = true, nullable = false, length = 45)
    private String name;

    @Min(0)
    @ColumnDefault(value = "0")
    private BigDecimal basePrice; // For precision

    @Size(max = 512)
    @Column(unique = true, length = 45)
    private String description;

    @Column(nullable = false)
    @ColumnDefault(value = "0")
    private Long delayTimeHours;

    @NotNull
    @ColumnDefault("false")
    private boolean deleted = false;

    @Size(max = 512)
    @Column(length = 512)
    private String image;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
    private Category category;

    @OneToMany(mappedBy = "baseProduct")
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private Set<PosibleCustomization> posibleCustomizations;

    public Set<PosibleCustomization> getPosibleCustomizations() {
        return new HashSet<>(this.posibleCustomizations);
    }

    public void addPosibleCustomization(PosibleCustomization item) {
        this.posibleCustomizations.add(item);
        item.setBaseProduct(this);
    }
}