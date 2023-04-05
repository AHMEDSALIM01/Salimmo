package org.propertyservice.validators;

import lombok.Getter;
import org.propertyservice.dto.PropertyDto;
import org.propertyservice.enums.PropertyStatus;
import org.springframework.stereotype.Component;


@Component
@Getter
public class PropertyValidator {
    private String message ;
    public Boolean isValid(PropertyDto propertyDto){
        if(propertyDto.getExteriorProperty() == null){
            this.message = "Exterior Details is required !";
            return false;
        }
        if(propertyDto.getInnerProperty() == null){
            this.message = "Inner Details is required !";
            return false;
        }
        if(propertyDto.getPropertyEnergies() == null){
            this.message = "Energies is required !";
            return false;
        }
        if(propertyDto.getPropertySurface() == null){
            this.message = "Surface is required !";
            return false;
        }
        if(propertyDto.getOwner() == null){
            this.message = "Owner is required !";
            return false;
        }
        if(propertyDto.getCategory() == null){
            this.message = "Category is required !";
            return false;
        }
        if(propertyDto.getType() == null){
            this.message = "Type is required !";
            return false;
       }
        if(propertyDto.getTitle() == null){
            this.message = "Title is required !";
            return false;
        }
        if(propertyDto.getNetPrice() == null){
            this.message = "Net Price is required !";
            return false;
        }
        if (propertyDto.getNetPrice().isNaN()){
            this.message = "Net Price should be a number !";
            return false;
        }
        if(propertyDto.getFees() == null){
            this.message = "Fees is required !";
            return false;
        }
        if(propertyDto.getFees().isNaN()){
            this.message = "Fees should be a number !";
            return false;
        }
        if(propertyDto.getNetPrice()<100){
            this.message = "Net Price is invalid, the min price is 100 !";
            return false;
        }
        if(propertyDto.getFees()<100){
            this.message = "Fees is invalid, the min fees is 100 !";
            return false;
        }
        if(propertyDto.getStatus() == null){
            this.message = "Property status is required";
            return false;
        }
        if(!propertyDto.getStatus().equals(PropertyStatus.valueOf("RENT")) || !propertyDto.getStatus().equals(PropertyStatus.valueOf("SELL"))){
            this.message = "Property status invalid";
            return false;
        }
        this.message = "";
        return true;
    }
}
