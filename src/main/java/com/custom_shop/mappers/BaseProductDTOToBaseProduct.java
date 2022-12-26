package com.custom_shop.mappers;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.custom_shop.DTO.BaseProductDTO;
import com.custom_shop.DTO.PosibleCustomizationDTO;
import com.custom_shop.model.BaseProduct;
import com.custom_shop.model.PosibleCustomization;
import com.custom_shop.repository.ICategoryRepo;

@Component
public class BaseProductDTOToBaseProduct implements IMapper<BaseProductDTO,BaseProduct>{

    @Autowired
    ICategoryRepo categoryRepo;

    @Override
    public BaseProduct map(BaseProductDTO in) {

        Set<PosibleCustomization> customizations = new HashSet<>();
        for (PosibleCustomizationDTO custDTO : in.getCustomizations()) {
            customizations.add(new PosibleCustomization(custDTO));
        }

        BaseProduct out = new BaseProduct(
            in.getName(), in.getBasePrice(), in.getDescription(),
            in.getDelayTimeHours(), in.getImage(),
            categoryRepo.findById(in.getCategoryId()).get(),
            customizations);
            
        return out;
    }

    
}
