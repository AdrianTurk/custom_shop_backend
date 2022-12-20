package com.custom_shop.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ColumnDefault;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "carts")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;

    @NotNull
    // @Column(unique=true)
    @OneToOne
    Buyer buyer;

    @OneToMany
    List<CartItem> cartItems;

    @OneToOne
    PaymentMethod paymentSelected;

    String receiverData;

    @ColumnDefault("false")
    @NotNull
    private boolean deleted = false;
}
