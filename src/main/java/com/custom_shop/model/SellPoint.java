package com.custom_shop.model;

import java.util.HashSet;
import java.util.Set;

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
    public SellPoint() {
        this.paymentMethods = new HashSet<>();
        this.customProducts = new HashSet<>();
    }

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
    private Set<PaymentMethod> paymentMethods;

    public Set<PaymentMethod> getPaymentMethods() {
        return new HashSet<>(this.paymentMethods);
    }

    public void addPaymentMethod(PaymentMethod item) {
        this.paymentMethods.add(item);
    }

    @OneToMany(mappedBy = "sellPoint")
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private Set<CustomProduct> customProducts;

    @ManyToOne()
    @JoinColumn(name = "owner_user_id", referencedColumnName = "id", nullable = false)
    private User ownerUser;

    public Set<CustomProduct> getCustomProducts() {
        return new HashSet<>(this.customProducts);
    }

    public void addCustomProducts(CustomProduct item) {
        this.customProducts.add(item);
        item.setSellPoint(this);
    }
}
