package com.custom_shop.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Entity(name = "sell_points")
@SQLDelete(sql = "UPDATE sell_points SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class SellPoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(min = 3, max = 45)
    @Column(unique = true, nullable = false, length = 45)
    private String name;

    @NotNull
    @ColumnDefault("false")
    private boolean deleted = false;

    @NotNull
    @ColumnDefault("false")
    private boolean deactivated = false;

    @ManyToMany
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private List<PaymentMethod> paymentMethods;

    public List<PaymentMethod> getPaymentMethods() {
        return new ArrayList<>(this.paymentMethods);
    }

    public void addPaymentMethod(PaymentMethod item) {
        this.paymentMethods.add(item);
    }

    @OneToMany(mappedBy = "sellPoint")
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private List<CustomProduct> customProducts;

    @ManyToOne()
    @JoinColumn(nullable = false)
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private User ownerUser;

    public List<CustomProduct> getCustomProducts() {
        return new ArrayList<>(this.customProducts);
    }

    public void addCustomProducts(CustomProduct item) {
        this.customProducts.add(item);
    }
}
