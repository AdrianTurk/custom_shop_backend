package com.custom_shop.model;

import java.util.ArrayList;
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
import lombok.AccessLevel;

@Getter
@Setter
@Entity(name = "carts")
public class Cart {

    public Cart() {
        this.cartItems = new ArrayList<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    // @Column(unique=true)
    @OneToOne
    private Buyer buyer;

    @OneToMany
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private List<CartItem> cartItems;

    public List<CartItem> getCartItems() {
        return new ArrayList<>(cartItems);
    }

    public void addCartItem(CartItem cartItem) {
        this.cartItems.add(cartItem);
    }

    @OneToOne
    private PaymentMethod paymentSelected;

    private String receiverData;

    @ColumnDefault("false")
    @NotNull
    private boolean deleted = false;
}
