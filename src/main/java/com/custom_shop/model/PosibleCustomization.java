package com.custom_shop.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
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
@NoArgsConstructor
@Entity(name = "posible_customizations")
@SQLDelete(sql = "UPDATE posible_customizations SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class PosibleCustomization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(min = 10, max = 45)
    @Column(unique = true, nullable = false, length = 45)
    private String name;

    @Size(min = 3, max = 45)
    @Column(unique = true, nullable = false, length = 45)
    private String description;

    @NotNull
    @Min(0)
    @Column(nullable = false)
    @ColumnDefault("0")
    private BigDecimal plusPrice;

    @Column(nullable = false)
    @ColumnDefault("0")
    private long hoursDelay;

    @ManyToOne
    @JoinColumn(nullable = false)
    private BaseProduct baseProduct;
}
