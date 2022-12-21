package com.custom_shop.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ColumnDefault;

import lombok.Getter;
import lombok.Setter;
import lombok.AccessLevel;

@Getter
@Setter
@Entity(name = "sellers")
public class Seller {

    public Seller() {
        this.customProducts = new ArrayList<CustomProduct>();
        this.paymentMethods = new ArrayList<PaymentMethod>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Email
    @Column(unique = true, nullable = false)
    private String email;

    @NotNull
    @Column(nullable = false)
    private String password;

    @ColumnDefault("false")
    @NotNull
    private boolean deleted = false;

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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seller", fetch = FetchType.LAZY)
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private List<CustomProduct> customProducts;

    // @JsonManagedReference
    public List<CustomProduct> getCustomProducts() {
        return new ArrayList<>(customProducts);
    }

    public void addCustomProduct(CustomProduct item) {
        this.customProducts.add(item);
    }

    public void patch(Seller newData) {
        // lo uso para poder implementar manualmente el patch en el rest controller
        // manual SellerController
        if (newData != null) {
            this.email = newData.email == null ? this.email : newData.email;
            this.name = newData.name == null ? this.name : newData.name;
            this.password = newData.password == null ? this.password : newData.password;
            // this.status = newData.status == null ? this.status : newData.status;

            if (newData.paymentMethods != null) {
                this.paymentMethods.clear();
                this.paymentMethods.addAll(newData.paymentMethods);
            }
        }
    }

    public void removePaymentMethod(Long id) {
        this.paymentMethods.removeIf(pymnt -> pymnt.getId() == id);
    }
}