package com.custom_shop.model;

import java.util.Set;

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

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "sellers")
@NoArgsConstructor
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idSeller;

    @Column(unique = true, nullable = false)
    private String name;

    @Email
    @Column(unique = true, nullable = false)
    private String email;

    @NotNull
    @Column(nullable = false)
    private String password;

    // @Enumerated(EnumType.STRING)
    // private LogicStatus status;

    @ColumnDefault("false")
    private boolean deleted = false;

    @ManyToMany
    Set<PaymentMethod> paymentMethods;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seller", fetch = FetchType.LAZY)
    Set<CustomProduct> customProducts;

    @JsonManagedReference
    public Set<CustomProduct> getCustomProducts() {
        return customProducts;
    }

    public void setCustomProducts(Set<CustomProduct> customProducts) {
        this.customProducts = customProducts;
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

}