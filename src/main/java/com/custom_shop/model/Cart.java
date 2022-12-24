package com.custom_shop.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.Getter;
import lombok.Setter;
import lombok.AccessLevel;

@Getter
@Setter
@Entity(name = "carts")
@SQLDelete(sql = "UPDATE carts SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Cart extends BaseEntity {

    public Cart() {
        this.cartItems = new ArrayList<>();
    }

    @Size(min = 10, max = 45)
    @Column(nullable = false, length = 45)
    private String address;

    @Column(columnDefinition = "DATE")
    @ColumnDefault(value="null")
    private LocalDate dispatchDate;

    @ManyToOne
    @JoinColumn(name = "owner_user_id", referencedColumnName = "id", nullable = false)
    private User ownerUser;

    @ManyToOne
    @JoinColumn(name = "paymentMethod_id", referencedColumnName = "id", nullable = false)
    private PaymentMethod paymentSelected;

    @OneToMany(mappedBy = "cart")
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private List<CartItem> cartItems;

    public List<CartItem> getCartItems() {
        return new ArrayList<>(cartItems);
    }

    public void addCartItem(CartItem cartItem) {
        this.cartItems.add(cartItem);
        cartItem.setCart(this);
    }
}
