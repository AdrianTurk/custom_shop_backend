package com.custom_shop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Entity(name = "payment_methods")
@SQLDelete(sql = "UPDATE payment_methods SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class PaymentMethod {

    // @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    // private long id;

    @NotNull
    @Size(min = 3, max = 3)
    @Id
    @Column(unique = true, nullable = false, length = 3)
    private String id;

    @NotNull
    @Size(min = 3, max = 30)
    @Column(unique = true, nullable = false, length = 30)
    private String methodName;

    @Size(max = 255)
    @Column(length = 255)
    private String description;

    @ColumnDefault("false")
    @NotNull
    private boolean deleted = false;

}