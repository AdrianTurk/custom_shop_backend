package com.custom_shop.DTO;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class BaseProductDTO {

    private Long id;

    @Size(min = 10, max = 45)
    private String name;

    @PositiveOrZero
    private BigDecimal basePrice;

    @Size(max = 512)
    private String description;

    @PositiveOrZero
    private Long delayTimeHours;

    @Size(max = 512)
    private String image;

    private long categoryId;

    private Set<PosibleCustomizationDTO> posibleCustomizations;

    public BaseProductDTO() {
        posibleCustomizations = new HashSet<>();
    }

    public Set<PosibleCustomizationDTO> getCustomizations() {
        return new HashSet<>(posibleCustomizations);
    }

    public void setCustomizations(Set<PosibleCustomizationDTO> customizations) {
        this.posibleCustomizations = new HashSet<>(customizations);
    }

    @Override
    public String toString() {
        return "BaseProductDTO [id=" + id + ", name=" + name + ", basePrice=" + basePrice + ", description="
                + description + ", delayTimeHours=" + delayTimeHours + ", image=" + image + ", categoryId=" + categoryId
                + ", posibleCustomizations=" + posibleCustomizations + "]";
    }
}
