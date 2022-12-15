package com.custom_shop.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.custom_shop.model.LogicStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SellerDTO {

    @NotNull
    private String name;

    @NotNull
    @Email
    private String email;

    private String password;

    private LogicStatus status;

    // Collection<PaymentMethod> paymentMethods;
    // Collection<CustomProduct> customProducts;

    public SellerDTO(String name, String email, String password, LogicStatus status) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.status = status;
    }

    public SellerDTO(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.status = LogicStatus.ACTIVE;
    }
}
