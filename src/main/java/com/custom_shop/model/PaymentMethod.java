package com.custom_shop.model;

import javax.persistence.Column;
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
@Entity(name = "payment_methods")
@NoArgsConstructor
public class PaymentMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idMethod;

    @NotNull
    @Column(unique = true)
    private String methodName;
    private String description;

    @ColumnDefault("false")
    @NotNull
    private boolean deleted = false;

    public PaymentMethod(String method, String description) {
        this.methodName = method;
        this.description = description;
    }
}
